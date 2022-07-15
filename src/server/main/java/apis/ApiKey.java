package apis;

// Enum to hold the different Api-keys

enum ApiKey {

    WEATHER_KEY("ac41346439bcc8dd543aedd632306b4c"),
    MAP_KEY("9GECRq8QYifLKMgRw1g2GvMNzLWeHwyA"),
    AIRLABS_KEY("f6753372-61ae-40c3-85ed-2333a7ea8b15"),
    POI_KEY("5ae2e3f221c38a28845f05b605dbd950bdd99b38cb834b3b9aa9a64e");

    private final String KEY;

    ApiKey(final String key){
        KEY = key;
    }

    public String getKEY() {
        return KEY;
    }
}