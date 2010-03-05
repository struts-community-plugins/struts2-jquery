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

package com.jgeppert.struts2.jquery.views.jsp.ui;

public interface SelectableTag {

  void setSelectable(String selectable);

  void setSelectableAutoRefresh(String selectableAutoRefresh);

  void setSelectableCancel(String selectableCancel);

  void setSelectableDelay(String selectableDelay);

  void setSelectableDistance(String selectableDistance);

  void setSelectableFilter(String selectableFilter);

  void setSelectableTolerance(String selectableTolerance);

  void setSelectableOnSelectedTopics(String selectableSelected);

  void setSelectableOnSelectingTopics(String selectableSelecting);

  void setSelectableOnStartTopics(String selectableStart);

  void setSelectableOnStopTopics(String selectableStop);

  void setSelectableOnUnselectedTopics(String selectableUnselected);

  void setSelectableOnUnselectingTopics(String selectableUnselecting);
}
