package com.pycreations.wordgame.databse

import android.app.Activity
import android.content.Context
import android.util.Log
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.OnUserEarnedRewardListener
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import androidx.compose.runtime.*
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView


object AdsServices {
    private var rewardedAd: RewardedAd? = null
    fun loadRewardedAds(context: Context) {
        val adRequest = AdRequest.Builder().build()

        RewardedAd.load(
            context,
            "ca-app-pub-3940256099942544/5224354917",
            adRequest,
            object : RewardedAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    adError.toString().let { Log.d("Check_Ads", it) }
                    rewardedAd = null
                }

                override fun onAdLoaded(ad: RewardedAd) {
                    Log.d("Check_Ads", "Ad was loaded.")
                    rewardedAd = ad
                }
            })
    }

    fun showRewardedAds(context: Context, onRewardEarn: () -> Unit, onFailed: () -> Unit) {
        if (rewardedAd == null) {
            onFailed()
            return
        }
        rewardedAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
            override fun onAdClicked() {
                super.onAdClicked()
            }

            override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                super.onAdFailedToShowFullScreenContent(p0)
            }

            override fun onAdDismissedFullScreenContent() {
                rewardedAd = null
            }

            override fun onAdImpression() {
                super.onAdImpression()
            }

            override fun onAdShowedFullScreenContent() {
                super.onAdShowedFullScreenContent()
            }
        }

        rewardedAd?.let { ad ->
            (context as? Activity)?.let {
                ad.show(it, OnUserEarnedRewardListener { rewardItem ->
                    // Handle the reward.
                    val rewardAmount = rewardItem.amount
                    val rewardType = rewardItem.type
                    Log.d("Ads_Status", "User earned the reward.")
                    onRewardEarn()
                })
            }
        } ?: run {
            onFailed()
            Log.d("Ads_Status", "The rewarded ad wasn't ready yet.")
        }
    }

    @Composable
    fun BannerAdView(context: Context) {
        AndroidView(
            factory = { ctx ->
                AdView(ctx).apply {
                    setAdSize(AdSize.BANNER)
                    adUnitId = "ca-app-pub-3940256099942544/9214589741"
                    loadAd(AdRequest.Builder().build())
                }
            },
            update = { it.loadAd(AdRequest.Builder().build()) }
        )
    }
}
