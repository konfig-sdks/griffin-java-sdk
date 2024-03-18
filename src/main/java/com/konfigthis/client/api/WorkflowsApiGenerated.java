/*
 * The Griffin API
 * ## Introduction  The Griffin API is based on [REST](https://en.wikipedia.org/wiki/Representational_state_transfer). It has resource-oriented URLs, accepts [JSON](https://www.json.org/json-en.html)-encoded request bodies, returns [JSON](https://www.json.org/json-en.html)-encoded responses, and uses standard HTTP response verbs and response codes.  Our API deviates from strict RESTful principles if it makes sense to do so, such as when we enforce tighter access controls around certain operations. For example, when closing a bank account: rather than send a PATCH request to the [bank account](http://docs.griffin.com) resource to update it's status to `\"closed\"`, we provide a dedicated account closure resource.  Anyone can [create an account](https://app.griffin.com/register) with Griffin and try out out API in [sandbox mode](http://docs.griffin.com).  New to Griffin? Check out our [getting started guide](http://docs.griffin.com).  ## Navigation  Our API is designed to be navigated programmatically. When you request any resource, you will find the URLs for related resources in the response body.  The API is structured as a tree with your [organization](http://docs.griffin.com) at the top. Everything that you own will be a sub-resource of your organization.  To bootstrap the navigation process, request the [index](http://docs.griffin.com) endpoint: the response will contain your `organization-url`.  For a walkthrough, see our [getting started guide](http://docs.griffin.com).  ## Pagination  Our list APIs support pagination (e.g. [list bank accounts](http://docs.griffin.com) and [list payments](http://docs.griffin.com)). By default, a list API returns up to 25 results. If there are more results available, the response payload will include links to the previous/next pages.  ### Change page size  You can request a different number of results (between 1 and 200, inclusive) by using the `page[size]` query parameter:  ``` GET /v0/organizations/:id/bank/accounts?page[size]=100 ```  ### Navigating between pages  List responses will include a `links` object with `prev` and `next` attributes, as shown below. Perform a GET request to the value of the attribute to fetch the previous/next page of results.  ``` {   \"accounts\": [     // ...   ],   \"links\": {     \"prev\": \"/v0/organizations/og.IG9yZ2FuaXphdGlvbi1pZA/bank/accounts?page[before]=djE6WxSPxfYUTnCU9XtWzj9gGA\",     \"next\": \"/v0/organizations/og.IG9yZ2FuaXphdGlvbi1pZA/bank/accounts?page[after]=djE6aw79PXZySUOL16LD8HRJ3A\"   } }  ``` If there is no previous or next page available, the value of the attribute will be  null.  Any other query parameters included in the initial request will also be included in the response payload's links. If you want to change parameters (see [filtering and sorting](http://docs.griffin.com)), request the first page and follow the links from there.  ## Filtering and sorting  ### Sort results  By default, resources will be listed in descending order, usually based on the `created-at` attribute. You can change the sorting behaviour of a list of results by using the `sort` query parameter.  For example, to list bank accounts in ascending order (oldest first):  ``` GET /v0/organizations/:id/bank/accounts?sort=created-at ```  To _explicitly_ sort in descending order (newest first), prefix the sort attribute with `-`:  ``` GET /v0/organizations/:id/bank/accounts?sort=-created-at ```  ### Filter results  Some list APIs allow you to filter the results. Filters are expressed as nested data structures encoded into query parameters. For example, you can list bank accounts that are in either the `opening` or `open` state with:  ``` GET /v0/organizations/:id/bank/accounts?filter[account-status][in][]=opening&filter[account-status][in][]=open ```  Similarly, you can list legal persons with a specific `application-status`:  ``` GET /v0/organizations/:id/legal-persons?filter[application-status][eq]=accepted ```  ### Include resources  Some list APIs allow you to include associated resources in the response, reducing the number of requests needed to fetch related data. For instance, when listing bank accounts, you can include each bank account's beneficiary legal person by using the `include` query parameter:  ``` GET /v0/organizations/:id/bank/accounts?include=beneficiary ```  The response returns the usual list of bank accounts, but it will also have an `included` object with a `legal-persons` attribute:  ``` {   \"accounts\": [     // ...   ],   \"links\": {     // ...   }   \"included\": {     \"legal-persons\": [       // ...     ]   } } ```  Check the documentation for each list API to see all options for sorting and filtering  ## Versioning  The Griffin API is versioned via a prefix in the URL. The current version is v0. An example endpoint is: https://api.griffin.com/v0/index.  We will not break your integration with a particular version for as long as we support that version. If we release a new version, you will have 12 months to upgrade to it.
 *
 * The version of the OpenAPI document: 
 * 
 *
 * NOTE: This class is auto generated by Konfig (https://konfigthis.com).
 * Do not edit the class manually.
 */


package com.konfigthis.client.api;

import com.konfigthis.client.ApiCallback;
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.Pair;
import com.konfigthis.client.ProgressRequestBody;
import com.konfigthis.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import com.konfigthis.client.model.WorkflowsGetWorkflowResponse;
import com.konfigthis.client.model.WorkflowsListOrganizationWorkflowsResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;

public class WorkflowsApiGenerated {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public WorkflowsApiGenerated() throws IllegalArgumentException {
        this(Configuration.getDefaultApiClient());
    }

    public WorkflowsApiGenerated(ApiClient apiClient) throws IllegalArgumentException {
        if (apiClient.getApiKeyAuth() == null) {
            throw new IllegalArgumentException("\"Authorization\" is required but no API key was provided. Please set \"Authorization\" with ApiClient#setApiKeyAuth(String).");
        }
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public int getHostIndex() {
        return localHostIndex;
    }

    public void setHostIndex(int hostIndex) {
        this.localHostIndex = hostIndex;
    }

    public String getCustomBaseUrl() {
        return localCustomBaseUrl;
    }

    public void setCustomBaseUrl(String customBaseUrl) {
        this.localCustomBaseUrl = customBaseUrl;
    }

    private okhttp3.Call getWorkflowCall(String workflowId, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v0/workflows/{workflow-id}"
            .replace("{" + "workflow-id" + "}", localVarApiClient.escapeString(workflowId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "api-key-auth" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getWorkflowValidateBeforeCall(String workflowId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'workflowId' is set
        if (workflowId == null) {
            throw new ApiException("Missing the required parameter 'workflowId' when calling getWorkflow(Async)");
        }

        return getWorkflowCall(workflowId, _callback);

    }


    private ApiResponse<WorkflowsGetWorkflowResponse> getWorkflowWithHttpInfo(String workflowId) throws ApiException {
        okhttp3.Call localVarCall = getWorkflowValidateBeforeCall(workflowId, null);
        Type localVarReturnType = new TypeToken<WorkflowsGetWorkflowResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getWorkflowAsync(String workflowId, final ApiCallback<WorkflowsGetWorkflowResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = getWorkflowValidateBeforeCall(workflowId, _callback);
        Type localVarReturnType = new TypeToken<WorkflowsGetWorkflowResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class GetWorkflowRequestBuilder {
        private final String workflowId;

        private GetWorkflowRequestBuilder(String workflowId) {
            this.workflowId = workflowId;
        }

        /**
         * Build call for getWorkflow
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return getWorkflowCall(workflowId, _callback);
        }


        /**
         * Execute getWorkflow request
         * @return WorkflowsGetWorkflowResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public WorkflowsGetWorkflowResponse execute() throws ApiException {
            ApiResponse<WorkflowsGetWorkflowResponse> localVarResp = getWorkflowWithHttpInfo(workflowId);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute getWorkflow request with HTTP info returned
         * @return ApiResponse&lt;WorkflowsGetWorkflowResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<WorkflowsGetWorkflowResponse> executeWithHttpInfo() throws ApiException {
            return getWorkflowWithHttpInfo(workflowId);
        }

        /**
         * Execute getWorkflow request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<WorkflowsGetWorkflowResponse> _callback) throws ApiException {
            return getWorkflowAsync(workflowId, _callback);
        }
    }

    /**
     * Get workflow
     * Fetch the workflow.
     * @param workflowId  (required)
     * @return GetWorkflowRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
        <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public GetWorkflowRequestBuilder getWorkflow(String workflowId) throws IllegalArgumentException {
        if (workflowId == null) throw new IllegalArgumentException("\"workflowId\" is required but got null");
            

        return new GetWorkflowRequestBuilder(workflowId);
    }
    private okhttp3.Call listOrganizationWorkflowsCall(String organizationId, String sort, Long pageSize, byte[] pageAfter, byte[] pageBefore, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v0/organizations/{organization-id}/workflows"
            .replace("{" + "organization-id" + "}", localVarApiClient.escapeString(organizationId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (sort != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("sort", sort));
        }

        if (pageSize != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("page[size]", pageSize));
        }

        if (pageAfter != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("page[after]", pageAfter));
        }

        if (pageBefore != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("page[before]", pageBefore));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "api-key-auth" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call listOrganizationWorkflowsValidateBeforeCall(String organizationId, String sort, Long pageSize, byte[] pageAfter, byte[] pageBefore, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling listOrganizationWorkflows(Async)");
        }

        return listOrganizationWorkflowsCall(organizationId, sort, pageSize, pageAfter, pageBefore, _callback);

    }


    private ApiResponse<WorkflowsListOrganizationWorkflowsResponse> listOrganizationWorkflowsWithHttpInfo(String organizationId, String sort, Long pageSize, byte[] pageAfter, byte[] pageBefore) throws ApiException {
        okhttp3.Call localVarCall = listOrganizationWorkflowsValidateBeforeCall(organizationId, sort, pageSize, pageAfter, pageBefore, null);
        Type localVarReturnType = new TypeToken<WorkflowsListOrganizationWorkflowsResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listOrganizationWorkflowsAsync(String organizationId, String sort, Long pageSize, byte[] pageAfter, byte[] pageBefore, final ApiCallback<WorkflowsListOrganizationWorkflowsResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = listOrganizationWorkflowsValidateBeforeCall(organizationId, sort, pageSize, pageAfter, pageBefore, _callback);
        Type localVarReturnType = new TypeToken<WorkflowsListOrganizationWorkflowsResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class ListOrganizationWorkflowsRequestBuilder {
        private final String organizationId;
        private String sort;
        private Long pageSize;
        private byte[] pageAfter;
        private byte[] pageBefore;

        private ListOrganizationWorkflowsRequestBuilder(String organizationId) {
            this.organizationId = organizationId;
        }

        /**
         * Set sort
         * @param sort  (optional)
         * @return ListOrganizationWorkflowsRequestBuilder
         */
        public ListOrganizationWorkflowsRequestBuilder sort(String sort) {
            this.sort = sort;
            return this;
        }
        
        /**
         * Set pageSize
         * @param pageSize  (optional)
         * @return ListOrganizationWorkflowsRequestBuilder
         */
        public ListOrganizationWorkflowsRequestBuilder pageSize(Long pageSize) {
            this.pageSize = pageSize;
            return this;
        }
        
        /**
         * Set pageAfter
         * @param pageAfter A base64 encoded opaque string returned in paginated responses. (optional)
         * @return ListOrganizationWorkflowsRequestBuilder
         */
        public ListOrganizationWorkflowsRequestBuilder pageAfter(byte[] pageAfter) {
            this.pageAfter = pageAfter;
            return this;
        }
        
        /**
         * Set pageBefore
         * @param pageBefore A base64 encoded opaque string returned in paginated responses. (optional)
         * @return ListOrganizationWorkflowsRequestBuilder
         */
        public ListOrganizationWorkflowsRequestBuilder pageBefore(byte[] pageBefore) {
            this.pageBefore = pageBefore;
            return this;
        }
        
        /**
         * Build call for listOrganizationWorkflows
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return listOrganizationWorkflowsCall(organizationId, sort, pageSize, pageAfter, pageBefore, _callback);
        }


        /**
         * Execute listOrganizationWorkflows request
         * @return WorkflowsListOrganizationWorkflowsResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public WorkflowsListOrganizationWorkflowsResponse execute() throws ApiException {
            ApiResponse<WorkflowsListOrganizationWorkflowsResponse> localVarResp = listOrganizationWorkflowsWithHttpInfo(organizationId, sort, pageSize, pageAfter, pageBefore);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute listOrganizationWorkflows request with HTTP info returned
         * @return ApiResponse&lt;WorkflowsListOrganizationWorkflowsResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<WorkflowsListOrganizationWorkflowsResponse> executeWithHttpInfo() throws ApiException {
            return listOrganizationWorkflowsWithHttpInfo(organizationId, sort, pageSize, pageAfter, pageBefore);
        }

        /**
         * Execute listOrganizationWorkflows request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<WorkflowsListOrganizationWorkflowsResponse> _callback) throws ApiException {
            return listOrganizationWorkflowsAsync(organizationId, sort, pageSize, pageAfter, pageBefore, _callback);
        }
    }

    /**
     * List organization workflows
     * Lists workflows for use when creating a [verification](http://docs.griffin.com).
     * @param organizationId  (required)
     * @return ListOrganizationWorkflowsRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
        <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public ListOrganizationWorkflowsRequestBuilder listOrganizationWorkflows(String organizationId) throws IllegalArgumentException {
        if (organizationId == null) throw new IllegalArgumentException("\"organizationId\" is required but got null");
            

        return new ListOrganizationWorkflowsRequestBuilder(organizationId);
    }
}
