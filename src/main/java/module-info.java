module isaatonimov.invy {

	requires java.desktop;
	requires java.compiler;
    requires javafx.controls;
	requires javafx.fxml;
	requires javafx.swing;
	requires com.dustinredmond.fxtrayicon;
	requires java.net.http;
	requires unirest.java;
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
	requires io.github.classgraph;
	requires org.apache.commons.io;

	opens isaatonimov.invy to javafx.fxml;
	exports isaatonimov.invy;
	exports isaatonimov.invy.models.piped to com.fasterxml.jackson.databind;
	exports isaatonimov.invy.models.musicbrainz to com.fasterxml.jackson.databind;
	exports isaatonimov.invy.models.invidious to com.fasterxml.jackson.databind;
	exports isaatonimov.invy.controllers;
	opens isaatonimov.invy.controllers to javafx.fxml;
	exports isaatonimov.invy.input;
	opens isaatonimov.invy.input to javafx.fxml;
	exports isaatonimov.invy.ui;
	opens isaatonimov.invy.ui to javafx.fxml;
	exports isaatonimov.invy.enums;
	opens isaatonimov.invy.enums to javafx.fxml;
	exports isaatonimov.invy.ui.base;
	opens isaatonimov.invy.ui.base to javafx.fxml;
}