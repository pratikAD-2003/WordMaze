package com.pycreations.wordgame.data.sentenceForm

object SentenceData {
    val sentenceLevels = listOf(
        // Levels 1-25 (Easy)
        SentenceModel("1", listOf("T", "R", "E", "E"), "TREE", "A ____ gives us shade."),
        SentenceModel("2", listOf("M", "O", "O", "N"), "MOON", "The ____ shines at night."),
        SentenceModel("3", listOf("B", "I", "R", "D"), "BIRD", "A ____ can fly in the sky."),
        SentenceModel("4", listOf("F", "I", "S", "H"), "FISH", "A ____ swims in the water."),
        SentenceModel("5", listOf("F", "O", "O", "D"), "FOOD", "We need ____ to survive."),
        SentenceModel("6", listOf("W", "A", "T", "E", "R"), "WATER", "We drink ____ every day."),
        SentenceModel("7", listOf("S", "U", "N"), "SUN", "The ____ is very hot."),
        SentenceModel("8", listOf("R", "A", "I", "N"), "RAIN", "I love the sound of ____."),
        SentenceModel("9", listOf("C", "A", "R"), "CAR", "He drives a fast ____."),
        SentenceModel("10", listOf("D", "O", "G"), "DOG", "The ____ is very loyal."),
        SentenceModel("11", listOf("C", "A", "T"), "CAT", "A ____ loves to sleep."),
        SentenceModel("12", listOf("H", "A", "T"), "HAT", "She wore a big ____."),
        SentenceModel("13", listOf("B", "O", "O", "K"), "BOOK", "I love to read a good ____."),
        SentenceModel("14", listOf("B", "O", "A", "T"), "BOAT", "A ____ sails on water."),
        SentenceModel("15", listOf("P", "A", "R", "K"), "PARK", "We went to the ____ for a walk."),
        SentenceModel("16", listOf("B", "E", "L", "L"), "BELL", "I heard the school ____ ring."),
        SentenceModel("17", listOf("B", "O", "X"), "BOX", "He opened a small ____."),
        SentenceModel("18", listOf("H", "A", "N", "D"), "HAND", "She raised her ____ to answer."),
        SentenceModel("19", listOf("H", "O", "M", "E"), "HOME", "I love my ____."),
        SentenceModel("20", listOf("B", "U", "S"), "BUS", "I took a ____ to school."),
        SentenceModel("21", listOf("L", "A", "M", "P"), "LAMP", "Turn on the ____."),
        SentenceModel(
            "22",
            listOf("R", "O", "C", "K"),
            "ROCK",
            "There was a large ____ on the ground."
        ),
        SentenceModel("23", listOf("D", "O", "O", "R"), "DOOR", "Please close the ____."),
        SentenceModel("24", listOf("C", "O", "I", "N"), "COIN", "I found a shiny ____."),
        SentenceModel("25", listOf("S", "O", "C", "K"), "SOCK", "I lost one ____."),

        // Levels 26-50 (Moderate)
        SentenceModel("26", listOf("C", "L", "O", "C", "K"), "CLOCK", "The ____ shows the time."),
        SentenceModel("27", listOf("P", "A", "P", "E", "R"), "PAPER", "I wrote a letter on ____."),
        SentenceModel("28", listOf("C", "H", "A", "I", "R"), "CHAIR", "She sat on the ____."),
        SentenceModel("29", listOf("T", "A", "B", "L", "E"), "TABLE", "We had dinner at the ____."),
        SentenceModel("30", listOf("P", "H", "O", "N", "E"), "PHONE", "He called me on his ____."),
        SentenceModel("31", listOf("G", "L", "A", "S", "S"), "GLASS", "I drank water from a ____."),
        SentenceModel(
            "32",
            listOf("P", "I", "L", "L", "O", "W"),
            "PILLOW",
            "I rest my head on a ____."
        ),
        SentenceModel(
            "33",
            listOf("W", "I", "N", "D", "O", "W"),
            "WINDOW",
            "She looked out of the ____."
        ),
        SentenceModel(
            "34",
            listOf("C", "U", "R", "T", "A", "I", "N"),
            "CURTAIN",
            "I closed the ____ for privacy."
        ),
        SentenceModel(
            "35",
            listOf("P", "I", "C", "T", "U", "R", "E"),
            "PICTURE",
            "He took a ____ of the sunset."
        ),
        SentenceModel(
            "36",
            listOf("F", "L", "O", "W", "E", "R"),
            "FLOWER",
            "She picked a beautiful ____."
        ),
        SentenceModel(
            "37",
            listOf("B", "R", "I", "D", "G", "E"),
            "BRIDGE",
            "We crossed the ____ by car."
        ),
        SentenceModel(
            "38",
            listOf("M", "I", "R", "R", "O", "R"),
            "MIRROR",
            "I looked at myself in the ____."
        ),
        SentenceModel(
            "39",
            listOf("B", "A", "L", "L", "O", "O", "N"),
            "BALLOON",
            "The child held a red ____."
        ),
        SentenceModel(
            "40",
            listOf("C", "A", "N", "D", "L", "E"),
            "CANDLE",
            "We lit a ____ for the dinner."
        ),
        SentenceModel(
            "41",
            listOf("T", "I", "C", "K", "E", "T"),
            "TICKET",
            "I bought a movie ____."
        ),
        SentenceModel(
            "42",
            listOf("C", "A", "M", "E", "R", "A"),
            "CAMERA",
            "He used a ____ to take photos."
        ),
        SentenceModel("43", listOf("L", "A", "U", "G", "H"), "LAUGH", "She has a wonderful ____."),
        SentenceModel(
            "44",
            listOf("B", "R", "E", "A", "D"),
            "BREAD",
            "I made a sandwich with ____."
        ),
        SentenceModel(
            "45",
            listOf("H", "E", "L", "M", "E", "T"),
            "HELMET",
            "He wore a ____ for safety."
        ),
        SentenceModel(
            "46",
            listOf("B", "A", "S", "K", "E", "T"),
            "BASKET",
            "She carried fruits in a ____."
        ),
        SentenceModel("47", listOf("C", "H", "E", "S", "T"), "CHEST", "He opened a wooden ____."),
        SentenceModel(
            "48",
            listOf("S", "H", "A", "D", "O", "W"),
            "SHADOW",
            "His ____ followed him."
        ),
        SentenceModel("49", listOf("C", "O", "U", "C", "H"), "COUCH", "She sat on the ____."),
        SentenceModel(
            "50",
            listOf("C", "O", "M", "P", "A", "S", "S"),
            "COMPASS",
            "A sailor uses a ____."
        ),

        // The remaining levels (51-250) will follow this structure
        SentenceModel(
            "51",
            listOf("L", "A", "D", "D", "E", "R"),
            "LADDER",
            "He climbed the ____ to fix the roof."
        ),
        SentenceModel(
            "52",
            listOf("S", "T", "A", "I", "R", "S"),
            "STAIRS",
            "She ran up the ____ quickly."
        ),
        SentenceModel(
            "53",
            listOf("P", "O", "C", "K", "E", "T"),
            "POCKET",
            "He kept his keys in his ____."
        ),
        SentenceModel(
            "54",
            listOf("C", "A", "R", "P", "E", "T"),
            "CARPET",
            "The room had a beautiful ____."
        ),
        SentenceModel(
            "55",
            listOf("F", "O", "R", "E", "S", "T"),
            "FOREST",
            "We went hiking in the ____."
        ),
        SentenceModel(
            "56",
            listOf("P", "E", "N", "C", "I", "L"),
            "PENCIL",
            "She wrote a note with a ____."
        ),
        SentenceModel(
            "57",
            listOf("T", "A", "B", "L", "E", "T"),
            "TABLET",
            "I read books on my ____."
        ),
        SentenceModel(
            "58",
            listOf("S", "C", "H", "O", "O", "L"),
            "SCHOOL",
            "Students study at ____."
        ),
        SentenceModel(
            "59",
            listOf("S", "U", "I", "T", "C", "A", "S", "E"),
            "SUITCASE",
            "He packed his clothes in a ____."
        ),
        SentenceModel(
            "60",
            listOf("B", "U", "L", "L", "E", "T"),
            "BULLET",
            "The gun fired a ____."
        ),

        SentenceModel(
            "61",
            listOf("C", "A", "N", "D", "L", "E"),
            "CANDLE",
            "She lit a ____ in the dark."
        ),
        SentenceModel("62", listOf("F", "A", "R", "M", "E", "R"), "FARMER", "A ____ grows crops."),
        SentenceModel(
            "63",
            listOf("C", "O", "U", "N", "T", "R", "Y"),
            "COUNTRY",
            "India is a beautiful ____."
        ),
        SentenceModel(
            "64",
            listOf("T", "E", "M", "P", "L", "E"),
            "TEMPLE",
            "They prayed at the ____."
        ),
        SentenceModel(
            "65",
            listOf("P", "A", "R", "A", "D", "I", "S", "E"),
            "PARADISE",
            "This island is a ____."
        ),
        SentenceModel(
            "66",
            listOf("A", "R", "T", "I", "S", "T"),
            "ARTIST",
            "He is a talented ____."
        ),
        SentenceModel(
            "67",
            listOf("T", "H", "E", "A", "T", "E", "R"),
            "THEATER",
            "They watched a play at the ____."
        ),
        SentenceModel(
            "68",
            listOf("L", "I", "G", "H", "T", "H", "O", "U"),
            "LIGHTHOUSE",
            "The ____ guided the ships."
        ),
        SentenceModel(
            "69",
            listOf("W", "H", "I", "S", "P", "E", "R"),
            "WHISPER",
            "She spoke in a soft ____."
        ),
        SentenceModel(
            "70",
            listOf("G", "A", "L", "A", "X", "Y"),
            "GALAXY",
            "The stars form a beautiful ____."
        ),
        SentenceModel(
            "71",
            listOf("R", "A", "I", "N"),
            "RAIN",
            "The ___ is falling heavily today."
        ),
        SentenceModel(
            "72",
            listOf("T", "R", "E", "E"),
            "TREE",
            "There is a big ___ in my backyard."
        ),
        SentenceModel(
            "73",
            listOf("F", "I", "S", "H"),
            "FISH",
            "He caught a big ___ in the river."
        ),
        SentenceModel(
            "74",
            listOf("M", "O", "O", "N"),
            "MOON",
            "The ___ shines brightly at night."
        ),
        SentenceModel(
            "75",
            listOf("S", "T", "A", "R"),
            "STAR",
            "That ___ is twinkling in the sky."
        ),
        SentenceModel("76", listOf("B", "I", "R", "D"), "BIRD", "A ___ is sitting on the branch."),
        SentenceModel("77", listOf("W", "A", "T", "E", "R"), "WATER", "I need a glass of ___."),
        SentenceModel(
            "78",
            listOf("H", "O", "U", "S", "E"),
            "HOUSE",
            "We live in a beautiful ___."
        ),
        SentenceModel(
            "79",
            listOf("C", "O", "U", "N", "T", "R", "Y"),
            "COUNTRY",
            "India is my ___."
        ),
        SentenceModel(
            "80",
            listOf("S", "C", "H", "O", "O", "L"),
            "SCHOOL",
            "We go to ___ every morning."
        ),
        SentenceModel(
            "81",
            listOf("F", "L", "O", "W", "E", "R"),
            "FLOWER",
            "A beautiful ___ bloomed in the garden."
        ),
        SentenceModel(
            "82",
            listOf("R", "I", "V", "E", "R"),
            "RIVER",
            "The ___ flows through the mountains."
        ),
        SentenceModel(
            "83",
            listOf("B", "R", "I", "D", "G", "E"),
            "BRIDGE",
            "We crossed the ___ to reach the other side."
        ),
        SentenceModel(
            "84",
            listOf("C", "L", "O", "C", "K"),
            "CLOCK",
            "The ___ shows the correct time."
        ),
        SentenceModel(
            "85",
            listOf("T", "A", "B", "L", "E"),
            "TABLE",
            "Please place the book on the ___."
        ),
        SentenceModel("86", listOf("C", "H", "A", "I", "R"), "CHAIR", "Sit on the ___."),
        SentenceModel("87", listOf("P", "E", "N", "C", "I", "L"), "PENCIL", "I sharpened my ___."),
        SentenceModel(
            "88",
            listOf("B", "A", "L", "L", "O", "O", "N"),
            "BALLOON",
            "She held a red ___."
        ),
        SentenceModel(
            "89",
            listOf("S", "U", "N", "S", "E", "T"),
            "SUNSET",
            "The ___ looks amazing at the beach."
        ),
        SentenceModel(
            "90",
            listOf("B", "E", "A", "C", "H"),
            "BEACH",
            "We are going to the ___ this summer."
        ),

        SentenceModel(
            "91",
            listOf("M", "O", "U", "N", "T", "A", "I", "N"),
            "MOUNTAIN",
            "The ___ is covered in snow."
        ),
        SentenceModel(
            "92",
            listOf("F", "O", "R", "E", "S", "T"),
            "FOREST",
            "The ___ is full of tall trees."
        ),
        SentenceModel(
            "93",
            listOf("C", "A", "R", "P", "E", "T"),
            "CARPET",
            "A red ___ is in the living room."
        ),
        SentenceModel(
            "94",
            listOf("L", "I", "G", "H", "T"),
            "LIGHT",
            "Turn off the ___ before sleeping."
        ),
        SentenceModel("95", listOf("M", "U", "S", "I", "C"), "MUSIC", "I love listening to ___."),
        SentenceModel(
            "96",
            listOf("C", "H", "O", "C", "O", "L", "A", "T", "E"),
            "CHOCOLATE",
            "He gave me a bar of ___."
        ),
        SentenceModel(
            "97",
            listOf("H", "O", "S", "P", "I", "T", "A", "L"),
            "HOSPITAL",
            "She was admitted to the ___."
        ),
        SentenceModel(
            "98",
            listOf("P", "A", "I", "N", "T", "I", "N", "G"),
            "PAINTING",
            "The ___ was hung on the wall."
        ),
        SentenceModel(
            "99",
            listOf("B", "O", "O", "K", "S", "H", "E", "L", "F"),
            "BOOKSHELF",
            "She arranged the books on the ___."
        ),
        SentenceModel(
            "100",
            listOf("C", "O", "M", "P", "U", "T", "E", "R"),
            "COMPUTER",
            "I work on my ___ daily."
        ),
        SentenceModel(
            "101",
            listOf("G", "A", "R", "D", "E", "N"),
            "GARDEN",
            "She planted flowers in the ___."
        ),
        SentenceModel(
            "102",
            listOf("S", "C", "H", "O", "O", "L"),
            "SCHOOL",
            "Children go to ___ to learn."
        ),
        SentenceModel(
            "103",
            listOf("C", "O", "L", "L", "E", "G", "E"),
            "COLLEGE",
            "He is studying at the ___."
        ),
        SentenceModel(
            "104",
            listOf("U", "M", "B", "R", "E", "L", "L", "A"),
            "UMBRELLA",
            "Take an ___, it's raining."
        ),
        SentenceModel(
            "105",
            listOf("L", "I", "B", "R", "A", "R", "Y"),
            "LIBRARY",
            "She borrowed books from the ___."
        ),
        SentenceModel(
            "106",
            listOf("C", "A", "M", "E", "R", "A"),
            "CAMERA",
            "I took a picture with my ___."
        ),
        SentenceModel(
            "107",
            listOf("A", "I", "R", "P", "L", "A", "N", "E"),
            "AIRPLANE",
            "The ___ took off at noon."
        ),
        SentenceModel(
            "108",
            listOf("S", "U", "I", "T", "C", "A", "S", "E"),
            "SUITCASE",
            "I packed my clothes in a ___."
        ),
        SentenceModel(
            "109",
            listOf("P", "I", "C", "N", "I", "C"),
            "PICNIC",
            "We had a ___ in the park."
        ),
        SentenceModel(
            "110",
            listOf("T", "H", "E", "A", "T", "E", "R"),
            "THEATER",
            "We watched a movie at the ___."
        ),

        SentenceModel(
            "111",
            listOf("V", "O", "L", "C", "A", "N", "O"),
            "VOLCANO",
            "The ___ erupted last night."
        ),
        SentenceModel(
            "112",
            listOf("S", "T", "A", "D", "I", "U", "M"),
            "STADIUM",
            "The match was held in a ___."
        ),
        SentenceModel(
            "113",
            listOf("M", "O", "N", "K", "E", "Y"),
            "MONKEY",
            "A ___ climbed the tree."
        ),
        SentenceModel(
            "114",
            listOf("E", "L", "E", "P", "H", "A", "N", "T"),
            "ELEPHANT",
            "The ___ has a long trunk."
        ),
        SentenceModel(
            "115",
            listOf("B", "I", "C", "Y", "C", "L", "E"),
            "BICYCLE",
            "He rides a ___ to school."
        ),
        SentenceModel(
            "116",
            listOf("S", "P", "I", "D", "E", "R"),
            "SPIDER",
            "A ___ spun a web in the corner."
        ),
        SentenceModel(
            "117",
            listOf("P", "E", "A", "C", "O", "C", "K"),
            "PEACOCK",
            "A ___ danced in the rain."
        ),
        SentenceModel(
            "118",
            listOf("C", "A", "T", "E", "R", "P", "I", "L", "L", "A", "R"),
            "CATERPILLAR",
            "A ___ turns into a butterfly."
        ),
        SentenceModel(
            "119",
            listOf("R", "A", "I", "N", "B", "O", "W"),
            "RAINBOW",
            "A beautiful ___ appeared after the rain."
        ),
        SentenceModel(
            "120",
            listOf("S", "N", "O", "W", "M", "A", "N"),
            "SNOWMAN",
            "The kids built a ___."
        ),
        SentenceModel(
            "121",
            listOf("C", "A", "R", "R", "O", "T"),
            "CARROT",
            "Rabbits love to eat ___."
        ),
        SentenceModel(
            "122",
            listOf("B", "R", "I", "D", "G", "E"),
            "BRIDGE",
            "We crossed the ___ over the river."
        ),
        SentenceModel(
            "123",
            listOf("T", "U", "N", "N", "E", "L"),
            "TUNNEL",
            "The train passed through the ___."
        ),
        SentenceModel(
            "124",
            listOf("M", "O", "U", "N", "T", "A", "I", "N"),
            "MOUNTAIN",
            "We hiked up the ___."
        ),
        SentenceModel(
            "125",
            listOf("F", "O", "R", "E", "S", "T"),
            "FOREST",
            "The ___ was full of tall trees."
        ),
        SentenceModel(
            "126",
            listOf("B", "E", "A", "C", "H"),
            "BEACH",
            "We played in the sand at the ___."
        ),
        SentenceModel(
            "127",
            listOf("C", "A", "S", "T", "L", "E"),
            "CASTLE",
            "The king lived in a large ___."
        ),
        SentenceModel(
            "128",
            listOf("D", "E", "S", "E", "R", "T"),
            "DESERT",
            "The camel walked through the ___."
        ),
        SentenceModel("129", listOf("I", "G", "L", "O", "O"), "IGLOO", "The Eskimos built an ___."),
        SentenceModel(
            "130",
            listOf("J", "U", "N", "G", "L", "E"),
            "JUNGLE",
            "The ___ is home to many wild animals."
        ),

        SentenceModel(
            "131",
            listOf("P", "A", "L", "A", "C", "E"),
            "PALACE",
            "The queen lives in a grand ___."
        ),
        SentenceModel("132", listOf("C", "A", "V", "E"), "CAVE", "The bats live in a dark ___."),
        SentenceModel("133", listOf("L", "A", "K", "E"), "LAKE", "The boat sailed across the ___."),
        SentenceModel(
            "134",
            listOf("O", "C", "E", "A", "N"),
            "OCEAN",
            "Whales live in the deep ___."
        ),
        SentenceModel(
            "135",
            listOf("P", "L", "A", "N", "E", "T"),
            "PLANET",
            "Earth is a beautiful ___."
        ),
        SentenceModel(
            "136",
            listOf("S", "T", "A", "R"),
            "STAR",
            "The sky was full of shining ___."
        ),
        SentenceModel(
            "137",
            listOf("G", "A", "L", "A", "X", "Y"),
            "GALAXY",
            "The Milky Way is a vast ___."
        ),
        SentenceModel(
            "138",
            listOf("M", "O", "O", "N"),
            "MOON",
            "The ___ glowed brightly in the night."
        ),
        SentenceModel("139", listOf("S", "U", "N"), "SUN", "The ___ rises in the east."),
        SentenceModel(
            "140",
            listOf("C", "L", "O", "U", "D"),
            "CLOUD",
            "The ___ floated in the sky."
        ),

        SentenceModel(
            "141",
            listOf("T", "E", "M", "P", "L", "E"),
            "TEMPLE",
            "We visited an ancient ___."
        ),
        SentenceModel(
            "142",
            listOf("M", "U", "S", "E", "U", "M"),
            "MUSEUM",
            "The paintings were displayed in a ___."
        ),
        SentenceModel(
            "143",
            listOf("M", "A", "R", "K", "E", "T"),
            "MARKET",
            "We bought fresh fruits at the ___."
        ),
        SentenceModel("144", listOf("P", "A", "R", "K"), "PARK", "Children played in the ___."),
        SentenceModel(
            "145",
            listOf("H", "O", "S", "P", "I", "T", "A", "L"),
            "HOSPITAL",
            "Doctors work in a ___."
        ),
        SentenceModel(
            "146",
            listOf("A", "I", "R", "P", "O", "R", "T"),
            "AIRPORT",
            "The plane landed at the ___."
        ),
        SentenceModel(
            "147",
            listOf("B", "U", "S", "S", "T", "O", "P"),
            "BUSSTOP",
            "We waited at the ___ for the bus."
        ),
        SentenceModel(
            "148",
            listOf("H", "O", "T", "E", "L"),
            "HOTEL",
            "We stayed in a five-star ___."
        ),
        SentenceModel(
            "149",
            listOf("C", "O", "L", "L", "E", "G", "E"),
            "COLLEGE",
            "She studies at a prestigious ___."
        ),
        SentenceModel(
            "150",
            listOf("U", "N", "I", "V", "E", "R", "S", "I", "T", "Y"),
            "UNIVERSITY",
            "He got admission into a ___."
        ),
        SentenceModel("151", listOf("B", "A", "N", "K"), "BANK", "He deposited money in the ___."),
        SentenceModel(
            "152",
            listOf("T", "H", "E", "A", "T", "E", "R"),
            "THEATER",
            "We watched a movie at the ___."
        ),
        SentenceModel(
            "153",
            listOf("L", "I", "B", "R", "A", "R", "Y"),
            "LIBRARY",
            "She borrowed books from the ___."
        ),
        SentenceModel(
            "154",
            listOf("F", "A", "C", "T", "O", "R", "Y"),
            "FACTORY",
            "Machines work in a ___."
        ),
        SentenceModel("155", listOf("Z", "O", "O"), "ZOO", "We saw lions and tigers at the ___."),
        SentenceModel(
            "156",
            listOf("G", "A", "R", "D", "E", "N"),
            "GARDEN",
            "She planted flowers in the ___."
        ),
        SentenceModel(
            "157",
            listOf("S", "T", "A", "D", "I", "U", "M"),
            "STADIUM",
            "The match was played in a ___."
        ),
        SentenceModel(
            "158",
            listOf("B", "R", "I", "D", "G", "E"),
            "BRIDGE",
            "Cars crossed the river via the ___."
        ),
        SentenceModel(
            "159",
            listOf("S", "T", "A", "T", "I", "O", "N"),
            "STATION",
            "We waited for the train at the ___."
        ),
        SentenceModel(
            "160",
            listOf("M", "A", "R", "K", "E", "T"),
            "MARKET",
            "She bought vegetables at the ___."
        ),

        SentenceModel(
            "161",
            listOf("O", "F", "F", "I", "C", "E"),
            "OFFICE",
            "He works in a corporate ___."
        ),
        SentenceModel("162", listOf("F", "A", "R", "M"), "FARM", "Cows and hens live on a ___."),
        SentenceModel(
            "163",
            listOf("H", "O", "S", "T", "E", "L"),
            "HOSTEL",
            "Students stay in a ___."
        ),
        SentenceModel("164", listOf("M", "A", "L", "L"), "MALL", "She went shopping at the ___."),
        SentenceModel("165", listOf("H", "O", "U", "S", "E"), "HOUSE", "They live in a big ___."),
        SentenceModel(
            "166",
            listOf("C", "I", "N", "E", "M", "A"),
            "CINEMA",
            "We watched a film at the ___."
        ),
        SentenceModel("167", listOf("R", "O", "A", "D"), "ROAD", "The car drove on the ___."),
        SentenceModel("168", listOf("B", "U", "S"), "BUS", "She took the ___ to school."),
        SentenceModel(
            "169",
            listOf("B", "O", "A", "T"),
            "BOAT",
            "They sailed across the lake in a ___."
        ),
        SentenceModel(
            "170",
            listOf("T", "R", "A", "I", "N"),
            "TRAIN",
            "The ___ arrived at the station."
        ),

        SentenceModel(
            "171",
            listOf("A", "I", "R", "P", "L", "A", "N", "E"),
            "AIRPLANE",
            "They traveled by ___."
        ),
        SentenceModel(
            "172",
            listOf("T", "R", "U", "C", "K"),
            "TRUCK",
            "The goods were loaded onto a ___."
        ),
        SentenceModel("173", listOf("B", "I", "K", "E"), "BIKE", "He rode his ___ to school."),
        SentenceModel(
            "174",
            listOf("S", "C", "H", "O", "O", "L"),
            "SCHOOL",
            "Children learn in ___."
        ),
        SentenceModel(
            "175",
            listOf("C", "O", "L", "L", "E", "G", "E"),
            "COLLEGE",
            "She studies at a ___."
        ),
        SentenceModel(
            "176",
            listOf("U", "N", "I", "V", "E", "R", "S", "I", "T", "Y"),
            "UNIVERSITY",
            "He got admission into a ___."
        ),
        SentenceModel(
            "177",
            listOf("H", "O", "S", "P", "I", "T", "A", "L"),
            "HOSPITAL",
            "Doctors work in a ___."
        ),
        SentenceModel(
            "178",
            listOf("C", "H", "U", "R", "C", "H"),
            "CHURCH",
            "They prayed in a ___."
        ),
        SentenceModel(
            "179",
            listOf("T", "E", "M", "P", "L", "E"),
            "TEMPLE",
            "We visited an ancient ___."
        ),
        SentenceModel(
            "180",
            listOf("M", "O", "S", "Q", "U", "E"),
            "MOSQUE",
            "They offered prayers at the ___."
        ),

        SentenceModel(
            "181",
            listOf("B", "E", "A", "C", "H"),
            "BEACH",
            "We played in the sand at the ___."
        ),
        SentenceModel(
            "182",
            listOf("F", "O", "R", "E", "S", "T"),
            "FOREST",
            "The ___ was full of tall trees."
        ),
        SentenceModel(
            "183",
            listOf("M", "O", "U", "N", "T", "A", "I", "N"),
            "MOUNTAIN",
            "We hiked up the ___."
        ),
        SentenceModel(
            "184",
            listOf("D", "E", "S", "E", "R", "T"),
            "DESERT",
            "The camel walked through the ___."
        ),
        SentenceModel("185", listOf("L", "A", "K", "E"), "LAKE", "The boat sailed across the ___."),
        SentenceModel(
            "186",
            listOf("O", "C", "E", "A", "N"),
            "OCEAN",
            "Whales live in the deep ___."
        ),
        SentenceModel(
            "187",
            listOf("C", "A", "S", "T", "L", "E"),
            "CASTLE",
            "The king lived in a large ___."
        ),
        SentenceModel(
            "188",
            listOf("P", "A", "L", "A", "C", "E"),
            "PALACE",
            "The queen lives in a grand ___."
        ),
        SentenceModel("189", listOf("I", "G", "L", "O", "O"), "IGLOO", "The Eskimos built an ___."),
        SentenceModel(
            "190",
            listOf("J", "U", "N", "G", "L", "E"),
            "JUNGLE",
            "The ___ is home to many wild animals."
        ),

        SentenceModel(
            "191",
            listOf("S", "T", "A", "R"),
            "STAR",
            "The sky was full of shining ___."
        ),
        SentenceModel("192", listOf("S", "U", "N"), "SUN", "The ___ rises in the east."),
        SentenceModel(
            "193",
            listOf("M", "O", "O", "N"),
            "MOON",
            "The ___ glowed brightly in the night."
        ),
        SentenceModel(
            "194",
            listOf("C", "L", "O", "U", "D"),
            "CLOUD",
            "The ___ floated in the sky."
        ),
        SentenceModel(
            "195",
            listOf("G", "A", "L", "A", "X", "Y"),
            "GALAXY",
            "The Milky Way is a vast ___."
        ),
        SentenceModel(
            "196",
            listOf("P", "L", "A", "N", "E", "T"),
            "PLANET",
            "Earth is a beautiful ___."
        ),
        SentenceModel(
            "197",
            listOf("R", "I", "V", "E", "R"),
            "RIVER",
            "The boat sailed down the ___."
        ),
        SentenceModel(
            "198",
            listOf("B", "R", "I", "D", "G", "E"),
            "BRIDGE",
            "Cars crossed the river via the ___."
        ),
        SentenceModel(
            "199",
            listOf("T", "U", "N", "N", "E", "L"),
            "TUNNEL",
            "The train passed through the ___."
        ),
        SentenceModel(
            "200",
            listOf("J", "O", "U", "R", "N", "A", "L"),
            "JOURNAL",
            "She writes in her ___ every night."
        ),
        SentenceModel("201", listOf("B", "O", "O", "K"), "BOOK", "He read an interesting ___."),
        SentenceModel(
            "202",
            listOf("N", "O", "T", "E", "B", "O", "O", "K"),
            "NOTEBOOK",
            "She wrote in her ___."
        ),
        SentenceModel(
            "203",
            listOf("P", "E", "N", "C", "I", "L"),
            "PENCIL",
            "He sharpened his ___."
        ),
        SentenceModel(
            "204",
            listOf("E", "R", "A", "S", "E", "R"),
            "ERASER",
            "She used an ___ to remove mistakes."
        ),
        SentenceModel(
            "205",
            listOf("S", "C", "I", "S", "S", "O", "R", "S"),
            "SCISSORS",
            "He cut the paper with ___."
        ),
        SentenceModel(
            "206",
            listOf("P", "A", "P", "E", "R"),
            "PAPER",
            "She folded the ___ into an airplane."
        ),
        SentenceModel(
            "207",
            listOf("G", "L", "O", "B", "E"),
            "GLOBE",
            "The teacher pointed at the ___."
        ),
        SentenceModel("208", listOf("M", "A", "P"), "MAP", "He used a ___ to find the way."),
        SentenceModel(
            "209",
            listOf("C", "O", "M", "P", "A", "S", "S"),
            "COMPASS",
            "The explorer carried a ___."
        ),
        SentenceModel(
            "210",
            listOf("P", "R", "I", "N", "T", "E", "R"),
            "PRINTER",
            "She printed documents using a ___."
        ),

        SentenceModel(
            "211",
            listOf("C", "O", "M", "P", "U", "T", "E", "R"),
            "COMPUTER",
            "He works on a ___."
        ),
        SentenceModel(
            "212",
            listOf("L", "A", "P", "T", "O", "P"),
            "LAPTOP",
            "She carries her ___ to class."
        ),
        SentenceModel(
            "213",
            listOf("M", "O", "U", "S", "E"),
            "MOUSE",
            "He clicked the ___ to select an item."
        ),
        SentenceModel(
            "214",
            listOf("K", "E", "Y", "B", "O", "A", "R", "D"),
            "KEYBOARD",
            "She typed on the ___."
        ),
        SentenceModel(
            "215",
            listOf("S", "P", "E", "A", "K", "E", "R"),
            "SPEAKER",
            "The ___ played loud music."
        ),
        SentenceModel(
            "216",
            listOf("M", "I", "C", "R", "O", "P", "H", "O", "N", "E"),
            "MICROPHONE",
            "He spoke into the ___."
        ),
        SentenceModel(
            "217",
            listOf("H", "E", "A", "D", "P", "H", "O", "N", "E", "S"),
            "HEADPHONES",
            "She listened to music with ___."
        ),
        SentenceModel(
            "218",
            listOf("T", "E", "L", "E", "V", "I", "S", "I", "O", "N"),
            "TELEVISION",
            "They watched cartoons on the ___."
        ),
        SentenceModel(
            "219",
            listOf("R", "A", "D", "I", "O"),
            "RADIO",
            "He listened to news on the ___."
        ),
        SentenceModel(
            "220",
            listOf("C", "A", "M", "E", "R", "A"),
            "CAMERA",
            "She took pictures with her ___."
        ),

        SentenceModel(
            "221",
            listOf("M", "O", "B", "I", "L", "E"),
            "MOBILE",
            "He made a call on his ___."
        ),
        SentenceModel(
            "222",
            listOf("T", "A", "B", "L", "E", "T"),
            "TABLET",
            "She played games on her ___."
        ),
        SentenceModel(
            "223",
            listOf("S", "M", "A", "R", "T", "W", "A", "T", "C", "H"),
            "SMARTWATCH",
            "He checked time on his ___."
        ),
        SentenceModel(
            "224",
            listOf("L", "I", "G", "H", "T", "B", "U", "L", "B"),
            "LIGHTBULB",
            "The ___ lit up the room."
        ),
        SentenceModel("225", listOf("L", "A", "M", "P"), "LAMP", "She turned on the ___."),
        SentenceModel("226", listOf("F", "A", "N"), "FAN", "The ___ cooled the room."),
        SentenceModel(
            "227",
            listOf("A", "I", "R", "C", "O", "N", "D", "I", "T", "I", "O", "N", "E", "R"),
            "AIR CONDITIONER",
            "He turned on the ___."
        ),
        SentenceModel(
            "228",
            listOf("H", "E", "A", "T", "E", "R"),
            "HEATER",
            "The ___ warmed the house."
        ),
        SentenceModel(
            "229",
            listOf("R", "E", "F", "R", "I", "G", "E", "R", "A", "T", "O", "R"),
            "REFRIGERATOR",
            "She kept food in the ___."
        ),
        SentenceModel(
            "230",
            listOf("W", "A", "S", "H", "I", "N", "G", "M", "A", "C", "H", "I", "N", "E"),
            "WASHING MACHINE",
            "The clothes were washed in a ___."
        ),

        SentenceModel(
            "231",
            listOf("M", "I", "C", "R", "O", "W", "A", "V", "E"),
            "MICROWAVE",
            "She heated food in the ___."
        ),
        SentenceModel("232", listOf("O", "V", "E", "N"), "OVEN", "The cake was baked in an ___."),
        SentenceModel(
            "233",
            listOf("T", "O", "A", "S", "T", "E", "R"),
            "TOASTER",
            "He toasted bread in a ___."
        ),
        SentenceModel(
            "234",
            listOf("M", "I", "X", "E", "R"),
            "MIXER",
            "She blended the ingredients in a ___."
        ),
        SentenceModel(
            "235",
            listOf("B", "L", "E", "N", "D", "E", "R"),
            "BLENDER",
            "He made a smoothie in the ___."
        ),
        SentenceModel(
            "236",
            listOf("K", "E", "T", "T", "L", "E"),
            "KETTLE",
            "She boiled water in the ___."
        ),
        SentenceModel(
            "237",
            listOf("C", "O", "F", "F", "E", "E", "M", "A", "C", "H", "I", "N", "E"),
            "COFFEE MACHINE",
            "He made coffee using a ___."
        ),
        SentenceModel(
            "238",
            listOf("D", "I", "S", "H", "W", "A", "S", "H", "E", "R"),
            "DISHWASHER",
            "The plates were cleaned in a ___."
        ),
        SentenceModel(
            "239",
            listOf("V", "A", "C", "U", "U", "M"),
            "VACUUM",
            "She cleaned the floor with a ___."
        ),
        SentenceModel(
            "240",
            listOf("I", "R", "O", "N"),
            "IRON",
            "He pressed his shirt with an ___."
        ),

        SentenceModel("241", listOf("C", "L", "O", "C", "K"), "CLOCK", "The ___ showed the time."),
        SentenceModel("242", listOf("A", "L", "A", "R", "M"), "ALARM", "The ___ woke him up."),
        SentenceModel(
            "243",
            listOf("C", "A", "L", "E", "N", "D", "A", "R"),
            "CALENDAR",
            "She checked the date on the ___."
        ),
        SentenceModel(
            "244",
            listOf("M", "I", "R", "R", "O", "R"),
            "MIRROR",
            "He looked at himself in the ___."
        ),
        SentenceModel(
            "245",
            listOf("T", "A", "B", "L", "E"),
            "TABLE",
            "The food was served on a ___."
        ),
        SentenceModel("246", listOf("C", "H", "A", "I", "R"), "CHAIR", "She sat on a ___."),
        SentenceModel("247", listOf("B", "E", "D"), "BED", "He slept on the ___."),
        SentenceModel("248", listOf("S", "O", "F", "A"), "SOFA", "She relaxed on the ___."),
        SentenceModel(
            "249",
            listOf("C", "U", "P", "B", "O", "A", "R", "D"),
            "CUPBOARD",
            "The dishes were kept in the ___."
        ),
        SentenceModel("250", listOf("D", "O", "O", "R"), "DOOR", "He knocked on the ___.")

    )

}