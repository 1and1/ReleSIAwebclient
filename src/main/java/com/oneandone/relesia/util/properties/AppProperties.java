/*
 * 
 * Copyright (c) 2016 1&1 Internet SE.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *        http://www.apache.org/licenses/LICENSE-2.0
 *        
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package com.oneandone.relesia.util.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppProperties {

	private static String configFile = "application.properties";

	private static Properties props = null;
	private static String envVarName = "SIA_FE_CONFIG_FILE";

	private static synchronized void init() {
		if (props == null) {
			props = new Properties();

			InputStream input = null;

			String filePath = System.getenv().get(envVarName);
			File propsFile =null;
			boolean loadDefaults = true;
			
			if (filePath != null) {
				propsFile = new File(configFile);

				if (propsFile.exists() && propsFile.isFile() && propsFile.canRead()) {
					loadDefaults = false;
					System.out.println("Loading properties from: " + propsFile.getAbsolutePath());
					
					try {
						input = new FileInputStream(propsFile);
					} catch (FileNotFoundException e) {
						System.out.println("FAILED loading properties from file [" + propsFile.getAbsolutePath() + "]. Loading defaults.");
						loadDefaults = true;
					}
				}
				
			}
			
			if (loadDefaults) {
				input = AppProperties.class.getClassLoader().getResourceAsStream(configFile);
				System.out.println("Loading default properties.");
			}
			
			try {
				props.load(input);
			} catch (IOException e) {
				props = null;
				System.out
						.println("FAILED loading properties! Unable to read from file: " + propsFile.getAbsolutePath());
				return;
			}
		}
	}

	public static String getProperty(String propertyName) {
		return getProperty(propertyName, null);
	}

	public static String getProperty(String propertyName, String defaultValue) {
		init();
		if (props == null) {
			return null;
		}
		return props.getProperty(propertyName, defaultValue);
	}
}
