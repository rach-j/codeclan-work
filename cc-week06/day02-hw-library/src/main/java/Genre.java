public enum Genre {
    THRILLER ("Thrillers are characterized and defined by the moods they elicit, giving viewers heightened feelings of suspense, excitement, surprise, anticipation and anxiety"),
    HORROR ("Horror is a genre of fiction which is intended to, or has the capacity to frighten, scare, disgust, or startle its readers or viewers by inducing feelings of horror and terror"),
    ROMANCE("Novels of the Romance genre place their primary focus on the relationship and romantic love between two people, and must have an \"emotionally satisfying and optimistic ending.\""),
    SCIFI ("Sci-fi is a genre in which fantasy, typically based on speculative scientific discoveries or developments, environmental changes, space travel, or life on other planets, forms part of the plot or background."),
    CRIME("Crime is a genre that fictionalises crimes, their detection, criminals, and their motives");

    private String description;

    Genre(String description) {this.description = description;}

    public String genreDescription() {
        return description;
    }

}
