package org.boli.myweb;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.HashMap;

import com.google.gson.Gson;

public class GsonTest {

	public static void main(String[] args) throws URISyntaxException, IOException {

		Gson gson = new Gson();

		InputStream inputStream = GsonTest.class.getClassLoader().getResourceAsStream("config.xml");

		Reader reader = new InputStreamReader(inputStream, Charset.forName("GBK"));

		HashMap<?, ?> map = gson.fromJson(reader, HashMap.class);

		reader.close();

		inputStream.close();

		File file = new File("E:\\eclipse-workspace\\repository\\myweb\\src\\test\\resources\\config.json");

		OutputStream outputStream = new FileOutputStream(file, false);

		Writer writer = new OutputStreamWriter(outputStream, Charset.forName("GBK"));

		gson.toJson(map, writer);

		writer.close();

		outputStream.close();

	}

}
