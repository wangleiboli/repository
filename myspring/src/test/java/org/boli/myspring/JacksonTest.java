package org.boli.myspring;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTest {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();

		InputStream inputStream = JacksonTest.class.getClassLoader().getResourceAsStream("config.xml");

		Reader reader = new InputStreamReader(inputStream, Charset.forName("GBK"));

		Map<?, ?> map = mapper.readValue(reader, Map.class);

		reader.close();

		inputStream.close();

		File file = new File("E:\\eclipse-workspace\\repository\\myspring\\src\\test\\resources\\config.json");

		OutputStream outputStream = new FileOutputStream(file, false);

		Writer writer = new OutputStreamWriter(outputStream, Charset.forName("GBK"));

		mapper.writeValue(writer, map);

		writer.close();

		outputStream.close();

	}

}
