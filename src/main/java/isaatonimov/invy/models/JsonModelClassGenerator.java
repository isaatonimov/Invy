package isaatonimov.invy.models;

import com.sun.codemodel.JCodeModel;
import isaatonimov.invy.utils.InvyUtils;
import org.jsonschema2pojo.*;
import org.jsonschema2pojo.rules.RuleFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonModelClassGenerator
{
	public static boolean generateJSONModelClassFromJSONString(String jsonSource, String className) throws IOException
	{
		String fileName = new SimpleDateFormat("yyyyMMddhhmmss'.json'").format(new Date());

		Path newPath = Paths.get(InvyUtils.getTempDirectoryPath().toString(), fileName);
		//Create file from JSON String
		Path jsonFilePath = Files.createFile(newPath);
		Files.write(jsonFilePath, jsonSource.getBytes());

		JCodeModel codeModel = new JCodeModel();

		GenerationConfig config = new DefaultGenerationConfig(){
			@Override
			public SourceType getSourceType()
			{
				return SourceType.JSON;
			}
		};

		SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new Jackson2Annotator(config), new SchemaStore()), new SchemaGenerator());
		mapper.generate(codeModel, className, "isaatonimov.invy.jsonmodels", jsonFilePath.toUri().toURL());

		String outputDir = "src/main/java/isaatonimov/invy/models";

		codeModel.build(new File(outputDir));

		return true;
	}
}
