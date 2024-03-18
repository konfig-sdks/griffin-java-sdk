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


import com.konfigthis.client.model.PooledAccountMembershipListLegalPersonsResponse;
import com.konfigthis.client.model.PooledAccountMembershipManageLegalPersonsRequest;
import com.konfigthis.client.model.PooledAccountMembershipManageLegalPersonsResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;

public class PooledAccountMembershipApiGenerated {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public PooledAccountMembershipApiGenerated() throws IllegalArgumentException {
        this(Configuration.getDefaultApiClient());
    }

    public PooledAccountMembershipApiGenerated(ApiClient apiClient) throws IllegalArgumentException {
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

    private okhttp3.Call listLegalPersonsCall(String bankAccountId, List<String> include, Long pageSize, byte[] pageAfter, byte[] pageBefore, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v0/bank/accounts/{bank-account-id}/membership"
            .replace("{" + "bank-account-id" + "}", localVarApiClient.escapeString(bankAccountId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (include != null) {
            localVarCollectionQueryParams.addAll(localVarApiClient.parameterToPairs("csv", "include", include));
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
    private okhttp3.Call listLegalPersonsValidateBeforeCall(String bankAccountId, List<String> include, Long pageSize, byte[] pageAfter, byte[] pageBefore, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'bankAccountId' is set
        if (bankAccountId == null) {
            throw new ApiException("Missing the required parameter 'bankAccountId' when calling listLegalPersons(Async)");
        }

        return listLegalPersonsCall(bankAccountId, include, pageSize, pageAfter, pageBefore, _callback);

    }


    private ApiResponse<PooledAccountMembershipListLegalPersonsResponse> listLegalPersonsWithHttpInfo(String bankAccountId, List<String> include, Long pageSize, byte[] pageAfter, byte[] pageBefore) throws ApiException {
        okhttp3.Call localVarCall = listLegalPersonsValidateBeforeCall(bankAccountId, include, pageSize, pageAfter, pageBefore, null);
        Type localVarReturnType = new TypeToken<PooledAccountMembershipListLegalPersonsResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listLegalPersonsAsync(String bankAccountId, List<String> include, Long pageSize, byte[] pageAfter, byte[] pageBefore, final ApiCallback<PooledAccountMembershipListLegalPersonsResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = listLegalPersonsValidateBeforeCall(bankAccountId, include, pageSize, pageAfter, pageBefore, _callback);
        Type localVarReturnType = new TypeToken<PooledAccountMembershipListLegalPersonsResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class ListLegalPersonsRequestBuilder {
        private final String bankAccountId;
        private List<String> include;
        private Long pageSize;
        private byte[] pageAfter;
        private byte[] pageBefore;

        private ListLegalPersonsRequestBuilder(String bankAccountId) {
            this.bankAccountId = bankAccountId;
        }

        /**
         * Set include
         * @param include For each member returned, include its legal person details, latest verification (if one exists), and/or latest risk rating (if one exists) in the response under the &#x60;included&#x60; attribute. (optional)
         * @return ListLegalPersonsRequestBuilder
         */
        public ListLegalPersonsRequestBuilder include(List<String> include) {
            this.include = include;
            return this;
        }
        
        /**
         * Set pageSize
         * @param pageSize  (optional)
         * @return ListLegalPersonsRequestBuilder
         */
        public ListLegalPersonsRequestBuilder pageSize(Long pageSize) {
            this.pageSize = pageSize;
            return this;
        }
        
        /**
         * Set pageAfter
         * @param pageAfter A base64 encoded opaque string returned in paginated responses. (optional)
         * @return ListLegalPersonsRequestBuilder
         */
        public ListLegalPersonsRequestBuilder pageAfter(byte[] pageAfter) {
            this.pageAfter = pageAfter;
            return this;
        }
        
        /**
         * Set pageBefore
         * @param pageBefore A base64 encoded opaque string returned in paginated responses. (optional)
         * @return ListLegalPersonsRequestBuilder
         */
        public ListLegalPersonsRequestBuilder pageBefore(byte[] pageBefore) {
            this.pageBefore = pageBefore;
            return this;
        }
        
        /**
         * Build call for listLegalPersons
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 403 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return listLegalPersonsCall(bankAccountId, include, pageSize, pageAfter, pageBefore, _callback);
        }


        /**
         * Execute listLegalPersons request
         * @return PooledAccountMembershipListLegalPersonsResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 403 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public PooledAccountMembershipListLegalPersonsResponse execute() throws ApiException {
            ApiResponse<PooledAccountMembershipListLegalPersonsResponse> localVarResp = listLegalPersonsWithHttpInfo(bankAccountId, include, pageSize, pageAfter, pageBefore);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute listLegalPersons request with HTTP info returned
         * @return ApiResponse&lt;PooledAccountMembershipListLegalPersonsResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 403 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<PooledAccountMembershipListLegalPersonsResponse> executeWithHttpInfo() throws ApiException {
            return listLegalPersonsWithHttpInfo(bankAccountId, include, pageSize, pageAfter, pageBefore);
        }

        /**
         * Execute listLegalPersons request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 403 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<PooledAccountMembershipListLegalPersonsResponse> _callback) throws ApiException {
            return listLegalPersonsAsync(bankAccountId, include, pageSize, pageAfter, pageBefore, _callback);
        }
    }

    /**
     * List legal person in a pooled account membership
     * List legal persons in a pooled account membership
     * @param bankAccountId  (required)
     * @return ListLegalPersonsRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
        <tr><td> 403 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public ListLegalPersonsRequestBuilder listLegalPersons(String bankAccountId) throws IllegalArgumentException {
        if (bankAccountId == null) throw new IllegalArgumentException("\"bankAccountId\" is required but got null");
            

        return new ListLegalPersonsRequestBuilder(bankAccountId);
    }
    private okhttp3.Call manageLegalPersonsCall(String bankAccountId, PooledAccountMembershipManageLegalPersonsRequest pooledAccountMembershipManageLegalPersonsRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = pooledAccountMembershipManageLegalPersonsRequest;

        // create path and map variables
        String localVarPath = "/v0/bank/accounts/{bank-account-id}/membership-updates"
            .replace("{" + "bank-account-id" + "}", localVarApiClient.escapeString(bankAccountId.toString()));

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
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "api-key-auth" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call manageLegalPersonsValidateBeforeCall(String bankAccountId, PooledAccountMembershipManageLegalPersonsRequest pooledAccountMembershipManageLegalPersonsRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'bankAccountId' is set
        if (bankAccountId == null) {
            throw new ApiException("Missing the required parameter 'bankAccountId' when calling manageLegalPersons(Async)");
        }

        // verify the required parameter 'pooledAccountMembershipManageLegalPersonsRequest' is set
        if (pooledAccountMembershipManageLegalPersonsRequest == null) {
            throw new ApiException("Missing the required parameter 'pooledAccountMembershipManageLegalPersonsRequest' when calling manageLegalPersons(Async)");
        }

        return manageLegalPersonsCall(bankAccountId, pooledAccountMembershipManageLegalPersonsRequest, _callback);

    }


    private ApiResponse<PooledAccountMembershipManageLegalPersonsResponse> manageLegalPersonsWithHttpInfo(String bankAccountId, PooledAccountMembershipManageLegalPersonsRequest pooledAccountMembershipManageLegalPersonsRequest) throws ApiException {
        okhttp3.Call localVarCall = manageLegalPersonsValidateBeforeCall(bankAccountId, pooledAccountMembershipManageLegalPersonsRequest, null);
        Type localVarReturnType = new TypeToken<PooledAccountMembershipManageLegalPersonsResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call manageLegalPersonsAsync(String bankAccountId, PooledAccountMembershipManageLegalPersonsRequest pooledAccountMembershipManageLegalPersonsRequest, final ApiCallback<PooledAccountMembershipManageLegalPersonsResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = manageLegalPersonsValidateBeforeCall(bankAccountId, pooledAccountMembershipManageLegalPersonsRequest, _callback);
        Type localVarReturnType = new TypeToken<PooledAccountMembershipManageLegalPersonsResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class ManageLegalPersonsRequestBuilder {
        private final List<String> additions;
        private final List<String> deletions;
        private final String bankAccountId;

        private ManageLegalPersonsRequestBuilder(List<String> additions, List<String> deletions, String bankAccountId) {
            this.additions = additions;
            this.deletions = deletions;
            this.bankAccountId = bankAccountId;
        }

        /**
         * Build call for manageLegalPersons
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Responds with bad-request if the body does not conform to the schema. </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 403 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 422 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            PooledAccountMembershipManageLegalPersonsRequest pooledAccountMembershipManageLegalPersonsRequest = buildBodyParams();
            return manageLegalPersonsCall(bankAccountId, pooledAccountMembershipManageLegalPersonsRequest, _callback);
        }

        private PooledAccountMembershipManageLegalPersonsRequest buildBodyParams() {
            PooledAccountMembershipManageLegalPersonsRequest pooledAccountMembershipManageLegalPersonsRequest = new PooledAccountMembershipManageLegalPersonsRequest();
            pooledAccountMembershipManageLegalPersonsRequest.additions(this.additions);
            pooledAccountMembershipManageLegalPersonsRequest.deletions(this.deletions);
            return pooledAccountMembershipManageLegalPersonsRequest;
        }

        /**
         * Execute manageLegalPersons request
         * @return PooledAccountMembershipManageLegalPersonsResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Responds with bad-request if the body does not conform to the schema. </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 403 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 422 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public PooledAccountMembershipManageLegalPersonsResponse execute() throws ApiException {
            PooledAccountMembershipManageLegalPersonsRequest pooledAccountMembershipManageLegalPersonsRequest = buildBodyParams();
            ApiResponse<PooledAccountMembershipManageLegalPersonsResponse> localVarResp = manageLegalPersonsWithHttpInfo(bankAccountId, pooledAccountMembershipManageLegalPersonsRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute manageLegalPersons request with HTTP info returned
         * @return ApiResponse&lt;PooledAccountMembershipManageLegalPersonsResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Responds with bad-request if the body does not conform to the schema. </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 403 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 422 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<PooledAccountMembershipManageLegalPersonsResponse> executeWithHttpInfo() throws ApiException {
            PooledAccountMembershipManageLegalPersonsRequest pooledAccountMembershipManageLegalPersonsRequest = buildBodyParams();
            return manageLegalPersonsWithHttpInfo(bankAccountId, pooledAccountMembershipManageLegalPersonsRequest);
        }

        /**
         * Execute manageLegalPersons request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td> Responds with bad-request if the body does not conform to the schema. </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 403 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 422 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<PooledAccountMembershipManageLegalPersonsResponse> _callback) throws ApiException {
            PooledAccountMembershipManageLegalPersonsRequest pooledAccountMembershipManageLegalPersonsRequest = buildBodyParams();
            return manageLegalPersonsAsync(bankAccountId, pooledAccountMembershipManageLegalPersonsRequest, _callback);
        }
    }

    /**
     * Manage pooled account members
     * Add and update the legal persons in a pooled account membership. Limited to 2000 legal persons per operation.
     * @param bankAccountId  (required)
     * @param pooledAccountMembershipManageLegalPersonsRequest  (required)
     * @return ManageLegalPersonsRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Responds with bad-request if the body does not conform to the schema. </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
        <tr><td> 403 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 422 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public ManageLegalPersonsRequestBuilder manageLegalPersons(List<String> additions, List<String> deletions, String bankAccountId) throws IllegalArgumentException {
        if (additions == null) throw new IllegalArgumentException("\"additions\" is required but got null");
        if (deletions == null) throw new IllegalArgumentException("\"deletions\" is required but got null");
        if (bankAccountId == null) throw new IllegalArgumentException("\"bankAccountId\" is required but got null");
            

        return new ManageLegalPersonsRequestBuilder(additions, deletions, bankAccountId);
    }
}
