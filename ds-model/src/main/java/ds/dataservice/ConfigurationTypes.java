package ds.dataservice;

public enum ConfigurationTypes {
    ALLOWED_TIME_CONFIG("timeConfig"),
    MAX_DOCS_PARTIC("maxDocsParticipation");

    private String name;

    ConfigurationTypes(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
