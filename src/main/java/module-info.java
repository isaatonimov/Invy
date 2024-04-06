module isaatonimov.invy {
	requires java.desktop;
	requires java.compiler;

    requires javafx.controls;
	requires javafx.media;
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

	opens isaatonimov.invy to javafx.fxml;
	exports isaatonimov.invy;
	exports isaatonimov.invy.jsonmodels to com.fasterxml.jackson.databind;
	exports isaatonimov.invy.controller;
	opens isaatonimov.invy.controller to javafx.fxml;
	exports isaatonimov.invy.misc;
	opens isaatonimov.invy.misc to javafx.fxml;
}