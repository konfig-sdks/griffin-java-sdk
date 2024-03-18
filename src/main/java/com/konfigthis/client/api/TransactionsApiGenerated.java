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


import java.time.OffsetDateTime;
import com.konfigthis.client.model.TransactionsGetTransactionByIdResponse;
import com.konfigthis.client.model.TransactionsListBalanceChangesResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;

public class TransactionsApiGenerated {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public TransactionsApiGenerated() throws IllegalArgumentException {
        this(Configuration.getDefaultApiClient());
    }

    public TransactionsApiGenerated(ApiClient apiClient) throws IllegalArgumentException {
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

    private okhttp3.Call getTransactionByIdCall(String transactionId, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v0/bank/transactions/{transaction-id}"
            .replace("{" + "transaction-id" + "}", localVarApiClient.escapeString(transactionId.toString()));

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
    private okhttp3.Call getTransactionByIdValidateBeforeCall(String transactionId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'transactionId' is set
        if (transactionId == null) {
            throw new ApiException("Missing the required parameter 'transactionId' when calling getTransactionById(Async)");
        }

        return getTransactionByIdCall(transactionId, _callback);

    }


    private ApiResponse<TransactionsGetTransactionByIdResponse> getTransactionByIdWithHttpInfo(String transactionId) throws ApiException {
        okhttp3.Call localVarCall = getTransactionByIdValidateBeforeCall(transactionId, null);
        Type localVarReturnType = new TypeToken<TransactionsGetTransactionByIdResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getTransactionByIdAsync(String transactionId, final ApiCallback<TransactionsGetTransactionByIdResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = getTransactionByIdValidateBeforeCall(transactionId, _callback);
        Type localVarReturnType = new TypeToken<TransactionsGetTransactionByIdResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class GetTransactionByIdRequestBuilder {
        private final String transactionId;

        private GetTransactionByIdRequestBuilder(String transactionId) {
            this.transactionId = transactionId;
        }

        /**
         * Build call for getTransactionById
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return getTransactionByIdCall(transactionId, _callback);
        }


        /**
         * Execute getTransactionById request
         * @return TransactionsGetTransactionByIdResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public TransactionsGetTransactionByIdResponse execute() throws ApiException {
            ApiResponse<TransactionsGetTransactionByIdResponse> localVarResp = getTransactionByIdWithHttpInfo(transactionId);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute getTransactionById request with HTTP info returned
         * @return ApiResponse&lt;TransactionsGetTransactionByIdResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<TransactionsGetTransactionByIdResponse> executeWithHttpInfo() throws ApiException {
            return getTransactionByIdWithHttpInfo(transactionId);
        }

        /**
         * Execute getTransactionById request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<TransactionsGetTransactionByIdResponse> _callback) throws ApiException {
            return getTransactionByIdAsync(transactionId, _callback);
        }
    }

    /**
     * Get transaction
     * Yields a bank account transaction
     * @param transactionId  (required)
     * @return GetTransactionByIdRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
        <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public GetTransactionByIdRequestBuilder getTransactionById(String transactionId) throws IllegalArgumentException {
        if (transactionId == null) throw new IllegalArgumentException("\"transactionId\" is required but got null");
            

        return new GetTransactionByIdRequestBuilder(transactionId);
    }
    private okhttp3.Call listBalanceChangesCall(String bankAccountId, String sort, Long pageSize, byte[] pageBefore, byte[] pageAfter, String include, OffsetDateTime filterPostDatetimeLte, OffsetDateTime filterPostDatetimeLt, OffsetDateTime filterPostDatetimeGte, OffsetDateTime filterPostDatetimeGt, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v0/bank/accounts/{bank-account-id}/transactions"
            .replace("{" + "bank-account-id" + "}", localVarApiClient.escapeString(bankAccountId.toString()));

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

        if (pageBefore != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("page[before]", pageBefore));
        }

        if (pageAfter != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("page[after]", pageAfter));
        }

        if (include != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("include", include));
        }

        if (filterPostDatetimeLte != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("filter[post-datetime][lte]", filterPostDatetimeLte));
        }

        if (filterPostDatetimeLt != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("filter[post-datetime][lt]", filterPostDatetimeLt));
        }

        if (filterPostDatetimeGte != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("filter[post-datetime][gte]", filterPostDatetimeGte));
        }

        if (filterPostDatetimeGt != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("filter[post-datetime][gt]", filterPostDatetimeGt));
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
    private okhttp3.Call listBalanceChangesValidateBeforeCall(String bankAccountId, String sort, Long pageSize, byte[] pageBefore, byte[] pageAfter, String include, OffsetDateTime filterPostDatetimeLte, OffsetDateTime filterPostDatetimeLt, OffsetDateTime filterPostDatetimeGte, OffsetDateTime filterPostDatetimeGt, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'bankAccountId' is set
        if (bankAccountId == null) {
            throw new ApiException("Missing the required parameter 'bankAccountId' when calling listBalanceChanges(Async)");
        }

        return listBalanceChangesCall(bankAccountId, sort, pageSize, pageBefore, pageAfter, include, filterPostDatetimeLte, filterPostDatetimeLt, filterPostDatetimeGte, filterPostDatetimeGt, _callback);

    }


    private ApiResponse<TransactionsListBalanceChangesResponse> listBalanceChangesWithHttpInfo(String bankAccountId, String sort, Long pageSize, byte[] pageBefore, byte[] pageAfter, String include, OffsetDateTime filterPostDatetimeLte, OffsetDateTime filterPostDatetimeLt, OffsetDateTime filterPostDatetimeGte, OffsetDateTime filterPostDatetimeGt) throws ApiException {
        okhttp3.Call localVarCall = listBalanceChangesValidateBeforeCall(bankAccountId, sort, pageSize, pageBefore, pageAfter, include, filterPostDatetimeLte, filterPostDatetimeLt, filterPostDatetimeGte, filterPostDatetimeGt, null);
        Type localVarReturnType = new TypeToken<TransactionsListBalanceChangesResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listBalanceChangesAsync(String bankAccountId, String sort, Long pageSize, byte[] pageBefore, byte[] pageAfter, String include, OffsetDateTime filterPostDatetimeLte, OffsetDateTime filterPostDatetimeLt, OffsetDateTime filterPostDatetimeGte, OffsetDateTime filterPostDatetimeGt, final ApiCallback<TransactionsListBalanceChangesResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = listBalanceChangesValidateBeforeCall(bankAccountId, sort, pageSize, pageBefore, pageAfter, include, filterPostDatetimeLte, filterPostDatetimeLt, filterPostDatetimeGte, filterPostDatetimeGt, _callback);
        Type localVarReturnType = new TypeToken<TransactionsListBalanceChangesResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class ListBalanceChangesRequestBuilder {
        private final String bankAccountId;
        private String sort;
        private Long pageSize;
        private byte[] pageBefore;
        private byte[] pageAfter;
        private String include;
        private OffsetDateTime filterPostDatetimeLte;
        private OffsetDateTime filterPostDatetimeLt;
        private OffsetDateTime filterPostDatetimeGte;
        private OffsetDateTime filterPostDatetimeGt;

        private ListBalanceChangesRequestBuilder(String bankAccountId) {
            this.bankAccountId = bankAccountId;
        }

        /**
         * Set sort
         * @param sort  (optional)
         * @return ListBalanceChangesRequestBuilder
         */
        public ListBalanceChangesRequestBuilder sort(String sort) {
            this.sort = sort;
            return this;
        }
        
        /**
         * Set pageSize
         * @param pageSize  (optional)
         * @return ListBalanceChangesRequestBuilder
         */
        public ListBalanceChangesRequestBuilder pageSize(Long pageSize) {
            this.pageSize = pageSize;
            return this;
        }
        
        /**
         * Set pageBefore
         * @param pageBefore A base64 encoded opaque string returned in paginated responses. (optional)
         * @return ListBalanceChangesRequestBuilder
         */
        public ListBalanceChangesRequestBuilder pageBefore(byte[] pageBefore) {
            this.pageBefore = pageBefore;
            return this;
        }
        
        /**
         * Set pageAfter
         * @param pageAfter A base64 encoded opaque string returned in paginated responses. (optional)
         * @return ListBalanceChangesRequestBuilder
         */
        public ListBalanceChangesRequestBuilder pageAfter(byte[] pageAfter) {
            this.pageAfter = pageAfter;
            return this;
        }
        
        /**
         * Set include
         * @param include For each transaction returned, include its payment (if one exists) in the response under the &#x60;included&#x60; attribute. (optional)
         * @return ListBalanceChangesRequestBuilder
         */
        public ListBalanceChangesRequestBuilder include(String include) {
            this.include = include;
            return this;
        }
        
        /**
         * Set filterPostDatetimeLte
         * @param filterPostDatetimeLte Return only resources with a created-at less than or equal to the given timestamp. (optional)
         * @return ListBalanceChangesRequestBuilder
         */
        public ListBalanceChangesRequestBuilder filterPostDatetimeLte(OffsetDateTime filterPostDatetimeLte) {
            this.filterPostDatetimeLte = filterPostDatetimeLte;
            return this;
        }
        
        /**
         * Set filterPostDatetimeLt
         * @param filterPostDatetimeLt Return only resources with a created-at less than the given timestamp. (optional)
         * @return ListBalanceChangesRequestBuilder
         */
        public ListBalanceChangesRequestBuilder filterPostDatetimeLt(OffsetDateTime filterPostDatetimeLt) {
            this.filterPostDatetimeLt = filterPostDatetimeLt;
            return this;
        }
        
        /**
         * Set filterPostDatetimeGte
         * @param filterPostDatetimeGte Return only resources with a created-at greater than or equal to the given timestamp. (optional)
         * @return ListBalanceChangesRequestBuilder
         */
        public ListBalanceChangesRequestBuilder filterPostDatetimeGte(OffsetDateTime filterPostDatetimeGte) {
            this.filterPostDatetimeGte = filterPostDatetimeGte;
            return this;
        }
        
        /**
         * Set filterPostDatetimeGt
         * @param filterPostDatetimeGt Return only resources with a created-at greater than the given timestamp. (optional)
         * @return ListBalanceChangesRequestBuilder
         */
        public ListBalanceChangesRequestBuilder filterPostDatetimeGt(OffsetDateTime filterPostDatetimeGt) {
            this.filterPostDatetimeGt = filterPostDatetimeGt;
            return this;
        }
        
        /**
         * Build call for listBalanceChanges
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return listBalanceChangesCall(bankAccountId, sort, pageSize, pageBefore, pageAfter, include, filterPostDatetimeLte, filterPostDatetimeLt, filterPostDatetimeGte, filterPostDatetimeGt, _callback);
        }


        /**
         * Execute listBalanceChanges request
         * @return TransactionsListBalanceChangesResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public TransactionsListBalanceChangesResponse execute() throws ApiException {
            ApiResponse<TransactionsListBalanceChangesResponse> localVarResp = listBalanceChangesWithHttpInfo(bankAccountId, sort, pageSize, pageBefore, pageAfter, include, filterPostDatetimeLte, filterPostDatetimeLt, filterPostDatetimeGte, filterPostDatetimeGt);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute listBalanceChanges request with HTTP info returned
         * @return ApiResponse&lt;TransactionsListBalanceChangesResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<TransactionsListBalanceChangesResponse> executeWithHttpInfo() throws ApiException {
            return listBalanceChangesWithHttpInfo(bankAccountId, sort, pageSize, pageBefore, pageAfter, include, filterPostDatetimeLte, filterPostDatetimeLt, filterPostDatetimeGte, filterPostDatetimeGt);
        }

        /**
         * Execute listBalanceChanges request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<TransactionsListBalanceChangesResponse> _callback) throws ApiException {
            return listBalanceChangesAsync(bankAccountId, sort, pageSize, pageBefore, pageAfter, include, filterPostDatetimeLte, filterPostDatetimeLt, filterPostDatetimeGte, filterPostDatetimeGt, _callback);
        }
    }

    /**
     * List transactions
     * Lists balance changes on a bank account.
     * @param bankAccountId  (required)
     * @return ListBalanceChangesRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
        <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public ListBalanceChangesRequestBuilder listBalanceChanges(String bankAccountId) throws IllegalArgumentException {
        if (bankAccountId == null) throw new IllegalArgumentException("\"bankAccountId\" is required but got null");
            

        return new ListBalanceChangesRequestBuilder(bankAccountId);
    }
}
