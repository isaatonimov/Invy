module isaatonimov.invy {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.media;
	requires java.net.http;
	requires com.dustinredmond.fxtrayicon;
	requires java.desktop;
	requires org.json;
	requires unirest.java;
	requires ffmpeg;
	requires musicbrainzws2.java;

	opens isaatonimov.invy to javafx.fxml;
    exports isaatonimov.invy;
}