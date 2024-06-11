/*
 * Copyright (C) Red Gate Software Ltd 2010-2022
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.flywaydb.community.database;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.flywaydb.community.database.db2z.DB2ZConfigurationExtension;
import org.flywaydb.core.api.FlywayException;
import org.flywaydb.core.extensibility.PluginMetadata;
import org.flywaydb.core.internal.util.FileUtils;

public class DB2ZDatabaseExtension implements PluginMetadata {

  public String getDescription() {
    return "Community-contributed DB2/zOS database support extension " + readVersion() + " by Redgate";
  }

  public static String readVersion() {
    try {
      return FileUtils.copyToString(
          DB2ZConfigurationExtension.class.getClassLoader().getResourceAsStream("org/flywaydb/community/database/db2z/version.txt"),
          StandardCharsets.UTF_8);
    } catch (IOException e) {
      throw new FlywayException("Unable to read extension version: " + e.getMessage(), e);
    }
  }

}
