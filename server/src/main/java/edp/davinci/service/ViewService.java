/*
 * <<
 *  Davinci
 *  ==
 *  Copyright (C) 2016 - 2019 EDP
 *  ==
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *        http://www.apache.org/licenses/LICENSE-2.0
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *  >>
 *
 */

package edp.davinci.service;

import edp.core.exception.NotFoundException;
import edp.core.exception.ServerException;
import edp.core.exception.UnAuthorizedException;
import edp.core.model.Paginate;
import edp.core.model.PaginateWithQueryColumns;
import edp.davinci.core.model.SqlEntity;
import edp.davinci.core.service.CheckEntityService;
import edp.davinci.dto.viewDto.*;
import edp.davinci.model.SqlVariable;
import edp.davinci.model.User;
import edp.davinci.service.excel.SQLContext;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ViewService extends CheckEntityService {

    List<ViewBaseInfo> getViews(Long projectId, User user) throws NotFoundException, UnAuthorizedException, ServerException;

    ViewWithSourceBaseInfo createView(ViewCreate viewCreate, User user) throws NotFoundException, UnAuthorizedException, ServerException;

    boolean updateView(ViewUpdate viewUpdate, User user) throws NotFoundException, UnAuthorizedException, ServerException;

    boolean deleteView(Long id, User user) throws NotFoundException, UnAuthorizedException, ServerException;

    PaginateWithQueryColumns executeSql(ViewExecuteSql executeSql, User user) throws NotFoundException, UnAuthorizedException, ServerException;

    Paginate<Map<String, Object>> getData(Long id, ViewExecuteParam executeParam, User user) throws NotFoundException, UnAuthorizedException, ServerException, SQLException;

    PaginateWithQueryColumns getResultDataList(boolean isMaintainer, ViewWithSource viewWithSource, ViewExecuteParam executeParam, User user) throws ServerException, SQLException;

    List<Map<String, Object>> getDistinctValue(Long id, DistinctParam param, User user) throws NotFoundException, ServerException, UnAuthorizedException;

    List getDistinctValueData(boolean isMaintainer, ViewWithSource viewWithSource, DistinctParam param, User user) throws ServerException;

    ViewWithSourceBaseInfo getView(Long id, User user) throws NotFoundException, UnAuthorizedException, ServerException;

    SQLContext getSQLContext(boolean isMaintainer, ViewWithSource viewWithSource, ViewExecuteParam executeParam, User user);

    void packageParams(boolean isProjectMaintainer, Long viewId, SqlEntity sqlEntity, List<SqlVariable> variables, List<Param> paramList, Set<String> excludeColumns, User user);
}
