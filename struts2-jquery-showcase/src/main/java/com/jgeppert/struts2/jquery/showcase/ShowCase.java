/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.jgeppert.struts2.jquery.showcase;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "showcase")
public class ShowCase extends ActionSupport {

  private static final long   serialVersionUID = -7133848243722723891L;
  private String              theme            = "showcase";
  private boolean             google           = false;
  private boolean             ajaxhistory      = false;
  private Map<String, String> themes;

  @Action(value = "/index", results = {
    @Result(location = "index.jsp", name = "success")
  })
  public String execute() throws Exception
  {

    themes = new HashMap<String, String>();
    themes.put("cupertino", "The cupertino Theme");
    themes.put("ui-darkness", "The darkness Theme");
    themes.put("ui-lightness", "The lightness Theme");
    themes.put("redmond", "The redmond Theme");
    themes.put("smoothness", "The smoothness Theme");
    themes.put("black-tie", "The black-tie Theme");
    themes.put("blitzer", "The blitzer Theme");
    themes.put("dark-hive", "The dark-hive Theme");
    themes.put("dot-luv", "The dot-luv Theme");
    themes.put("eggplant", "The eggplant Theme");
    themes.put("excite-bike", "The excite-bike Theme");
    themes.put("flick", "The flick Theme");
    themes.put("hot-sneaks", "The hot-sneaks Theme");
    themes.put("humanity", "The humanity Theme");
    themes.put("le-frog", "The le-frog Theme");
    themes.put("mint-choc", "The mint-choc Theme");
    themes.put("overcast", "The overcast Theme");
    themes.put("pepper-grinder", "The pepper-grinder Theme");
    themes.put("south-street", "The south-street Theme");
    themes.put("start", "The start Theme");
    themes.put("sunny", "The sunny Theme");
    themes.put("swanky-purse", "The swanky-purse Theme");
    themes.put("trontastic", "The trontastic Theme");
    themes.put("vader", "The vader Theme");

    themes.put("showcase", "The custom Showcase Theme");

    return SUCCESS;
  }

  public String getTheme()
  {
    return theme;
  }

  public void setTheme(String theme)
  {
    this.theme = theme;
  }

  public Map<String, String> getThemes()
  {
    return themes;
  }

  public boolean isGoogle()
  {
    return google;
  }

  public void setGoogle(boolean google)
  {
    this.google = google;
  }

  public boolean isAjaxhistory()
  {
    return ajaxhistory;
  }

  public void setAjaxhistory(boolean ajaxhistory)
  {
    this.ajaxhistory = ajaxhistory;
  }
}
