module isaatonimov.invy {

	requires java.desktop;
	requires java.compiler;
    requires javafx.controls;
	requires javafx.swing;
	requires javafx.fxml;
	requires java.net.http;
	requires unirest.java;
	requires com.dustinredmond.fxtrayicon;
	requires com.github.kwhat.jnativehook;
	requires org.jetbrains.annotations;
	requires jsonschema2pojo.core;
	requires codemodel;
	requires com.fasterxml.jackson.core;
	requires com.fasterxml.jackson.databind;
	requires com.fasterxml.jackson.annotation;
	requires uk.co.caprica.vlcj;
	requires com.dlsc.preferencesfx;
	requires org.slf4j;
	requires org.controlsfx.controls;
	requires javafx.media;
	requires fontawesomefx;

	opens isaatonimov.invy to javafx.fxml;
	exports isaatonimov.invy;
	exports isaatonimov.invy.models.piped to com.fasterxml.jackson.databind;
	exports isaatonimov.invy.models.musicbrainz to com.fasterxml.jackson.databind;
	exports isaatonimov.invy.models.invidious to com.fasterxml.jackson.databind;
	exports isaatonimov.invy.controller;
	opens isaatonimov.invy.controller to javafx.fxml;
	exports isaatonimov.invy.misc;
	opens isaatonimov.invy.misc to javafx.fxml;
	exports isaatonimov.invy.ui;
	opens isaatonimov.invy.ui to javafx.fxml;
}