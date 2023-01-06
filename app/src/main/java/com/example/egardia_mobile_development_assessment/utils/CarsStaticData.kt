package com.example.egardia_mobile_development_assessment.utils

import com.example.egardia_mobile_development_assessment.data.model.Cars
import com.google.gson.Gson




val carsListString =  "[\n" +
        "  {\n" +
        "    \"make\": \"Mercedes-Benz\",\n" +
        "    \"model\": \"A 180\",\n" +
        "    \"price\": \"13600.00\",\n" +
        "    \"year\": \"2015\",\n" +
        "    \"km\": \"130000\",\n" +
        "    \"picture\": \"https://media.autoweek.nl/m/kmayxerb6txf_800.jpg\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"make\": \"Audi\",\n" +
        "    \"model\": \"A1 1.6 TDI Sportback S tronic\",\n" +
        "    \"price\": \"7600.00\",\n" +
        "    \"year\": \"2017\",\n" +
        "    \"km\": \"17000\",\n" +
        "    \"picture\": \"https://media.autoweek.nl/m/m1fy0wfbu3p5_800.jpg\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"make\": \"BMW\",\n" +
        "    \"model\": \"530 Serie 5 (F10/F11) xDrive 249CV Touring Msport\",\n" +
        "    \"price\": \"6500.00\",\n" +
        "    \"year\": \"2016\",\n" +
        "    \"km\": \"180000\",\n" +
        "    \"picture\": \"https://media.autoweek.nl/m/yd3y09ab4rw1_800.jpg\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"make\": \"Ford\",\n" +
        "    \"model\": \"Fiesta 1.25 Trend 82CV 5P\",\n" +
        "    \"price\": \"6450.00\",\n" +
        "    \"year\": \"2015\",\n" +
        "    \"km\": \"46588\",\n" +
        "    \"picture\": \"https://media.autoweek.nl/m/m1dywfxbhnc2_800.jpg\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"make\": \"Opel\",\n" +
        "    \"model\": \"Corsa 1.3 CDTI Enjoy Start/Stop\",\n" +
        "    \"price\": \"5200.00\",\n" +
        "    \"year\": \"2015\",\n" +
        "    \"km\": \"245000\",\n" +
        "    \"picture\": \"https://drive.google.com/open?id=1Tdk5N4rYgYiIjknakr6e-bT0PcDxGlts\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"make\": \"Renault\",\n" +
        "    \"model\": \"Clio 1.5 dCi 8V 75CV 5 porte, Van 4 posti.\",\n" +
        "    \"price\": \"6699.00\",\n" +
        "    \"year\": \"2015\",\n" +
        "    \"km\": \"82167\",\n" +
        "    \"picture\": \"https://media.autoweek.nl/m/m1fygj9bmhop_800.jpg\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"make\": \"Volkswagen\",\n" +
        "    \"model\": \"Golf VII 7 Variant *1. HAND * EURO 6 * Temp\",\n" +
        "    \"price\": \"8450.00\",\n" +
        "    \"year\": \"2015\",\n" +
        "    \"km\": \"198700\",\n" +
        "    \"picture\": \"https://media.autoweek.nl/m/m1myt4eb7p8y_800.jpg\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"make\": \"Maserati\",\n" +
        "    \"model\": \"Quattroporte\",\n" +
        "    \"price\": \"336250.00\",\n" +
        "    \"year\": \"2016\",\n" +
        "    \"km\": \"47000\",\n" +
        "    \"picture\": \"https://www.mupload.nl/img/mr2dor.jpg\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"make\": \"Alfa Romeo\",\n" +
        "    \"model\": \" MiTo 1.4 70 CV 8V\",\n" +
        "    \"price\": \"7400.00\",\n" +
        "    \"year\": \"2015\",\n" +
        "    \"km\": \"49000\",\n" +
        "    \"picture\": \"https://media.autoweek.nl/m/kthy881ba6r4_800.jpg\"\n" +
        "  }\n" +
        "]";

val carlistFromUitls = Gson().fromJson<Cars>(carsListString, Cars::class.java)