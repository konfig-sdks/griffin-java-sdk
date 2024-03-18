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


import com.konfigthis.client.model.VerificationsGetVerificationResponse;
import com.konfigthis.client.model.VerificationsInitiateVerificationRequest;
import com.konfigthis.client.model.VerificationsInitiateVerificationResponse;
import com.konfigthis.client.model.VerificationsListForLegalPersonResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;

public class VerificationsApiGenerated {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public VerificationsApiGenerated() throws IllegalArgumentException {
        this(Configuration.getDefaultApiClient());
    }

    public VerificationsApiGenerated(ApiClient apiClient) throws IllegalArgumentException {
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

    private okhttp3.Call getVerificationCall(String verificationId, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v0/verifications/{verification-id}"
            .replace("{" + "verification-id" + "}", localVarApiClient.escapeString(verificationId.toString()));

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
    private okhttp3.Call getVerificationValidateBeforeCall(String verificationId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'verificationId' is set
        if (verificationId == null) {
            throw new ApiException("Missing the required parameter 'verificationId' when calling getVerification(Async)");
        }

        return getVerificationCall(verificationId, _callback);

    }


    private ApiResponse<VerificationsGetVerificationResponse> getVerificationWithHttpInfo(String verificationId) throws ApiException {
        okhttp3.Call localVarCall = getVerificationValidateBeforeCall(verificationId, null);
        Type localVarReturnType = new TypeToken<VerificationsGetVerificationResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getVerificationAsync(String verificationId, final ApiCallback<VerificationsGetVerificationResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = getVerificationValidateBeforeCall(verificationId, _callback);
        Type localVarReturnType = new TypeToken<VerificationsGetVerificationResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class GetVerificationRequestBuilder {
        private final String verificationId;

        private GetVerificationRequestBuilder(String verificationId) {
            this.verificationId = verificationId;
        }

        /**
         * Build call for getVerification
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
            return getVerificationCall(verificationId, _callback);
        }


        /**
         * Execute getVerification request
         * @return VerificationsGetVerificationResponse
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
        public VerificationsGetVerificationResponse execute() throws ApiException {
            ApiResponse<VerificationsGetVerificationResponse> localVarResp = getVerificationWithHttpInfo(verificationId);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute getVerification request with HTTP info returned
         * @return ApiResponse&lt;VerificationsGetVerificationResponse&gt;
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
        public ApiResponse<VerificationsGetVerificationResponse> executeWithHttpInfo() throws ApiException {
            return getVerificationWithHttpInfo(verificationId);
        }

        /**
         * Execute getVerification request (asynchronously)
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
        public okhttp3.Call executeAsync(final ApiCallback<VerificationsGetVerificationResponse> _callback) throws ApiException {
            return getVerificationAsync(verificationId, _callback);
        }
    }

    /**
     * Get verification
     * Fetch the verification.
     * @param verificationId  (required)
     * @return GetVerificationRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
        <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public GetVerificationRequestBuilder getVerification(String verificationId) throws IllegalArgumentException {
        if (verificationId == null) throw new IllegalArgumentException("\"verificationId\" is required but got null");
            

        return new GetVerificationRequestBuilder(verificationId);
    }
    private okhttp3.Call initiateVerificationCall(String legalPersonId, VerificationsInitiateVerificationRequest verificationsInitiateVerificationRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = verificationsInitiateVerificationRequest;

        // create path and map variables
        String localVarPath = "/v0/legal-persons/{legal-person-id}/verifications"
            .replace("{" + "legal-person-id" + "}", localVarApiClient.escapeString(legalPersonId.toString()));

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
    private okhttp3.Call initiateVerificationValidateBeforeCall(String legalPersonId, VerificationsInitiateVerificationRequest verificationsInitiateVerificationRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'legalPersonId' is set
        if (legalPersonId == null) {
            throw new ApiException("Missing the required parameter 'legalPersonId' when calling initiateVerification(Async)");
        }

        // verify the required parameter 'verificationsInitiateVerificationRequest' is set
        if (verificationsInitiateVerificationRequest == null) {
            throw new ApiException("Missing the required parameter 'verificationsInitiateVerificationRequest' when calling initiateVerification(Async)");
        }

        return initiateVerificationCall(legalPersonId, verificationsInitiateVerificationRequest, _callback);

    }


    private ApiResponse<VerificationsInitiateVerificationResponse> initiateVerificationWithHttpInfo(String legalPersonId, VerificationsInitiateVerificationRequest verificationsInitiateVerificationRequest) throws ApiException {
        okhttp3.Call localVarCall = initiateVerificationValidateBeforeCall(legalPersonId, verificationsInitiateVerificationRequest, null);
        Type localVarReturnType = new TypeToken<VerificationsInitiateVerificationResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call initiateVerificationAsync(String legalPersonId, VerificationsInitiateVerificationRequest verificationsInitiateVerificationRequest, final ApiCallback<VerificationsInitiateVerificationResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = initiateVerificationValidateBeforeCall(legalPersonId, verificationsInitiateVerificationRequest, _callback);
        Type localVarReturnType = new TypeToken<VerificationsInitiateVerificationResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class InitiateVerificationRequestBuilder {
        private final String workflowUrl;
        private final String legalPersonId;

        private InitiateVerificationRequestBuilder(String workflowUrl, String legalPersonId) {
            this.workflowUrl = workflowUrl;
            this.legalPersonId = legalPersonId;
        }

        /**
         * Build call for initiateVerification
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> The created verification </td><td>  * Location - The URL to check the progress of the test <br>  </td></tr>
            <tr><td> 400 </td><td> Bad Request: specific error details will be provided, if available </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td> Not Found: An associated legal person or workflow does not exist </td><td>  -  </td></tr>
            <tr><td> 409 </td><td> Conflict: An existing verification is in-flight </td><td>  -  </td></tr>
            <tr><td> 422 </td><td> Unprocessable Entity: specific error details will be provided, if available </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error: please contact support@griffin.com </td><td>  -  </td></tr>
            <tr><td> 502 </td><td> Bad Gateway: An error occurred with an external service integration </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            VerificationsInitiateVerificationRequest verificationsInitiateVerificationRequest = buildBodyParams();
            return initiateVerificationCall(legalPersonId, verificationsInitiateVerificationRequest, _callback);
        }

        private VerificationsInitiateVerificationRequest buildBodyParams() {
            VerificationsInitiateVerificationRequest verificationsInitiateVerificationRequest = new VerificationsInitiateVerificationRequest();
            verificationsInitiateVerificationRequest.workflowUrl(this.workflowUrl);
            return verificationsInitiateVerificationRequest;
        }

        /**
         * Execute initiateVerification request
         * @return VerificationsInitiateVerificationResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> The created verification </td><td>  * Location - The URL to check the progress of the test <br>  </td></tr>
            <tr><td> 400 </td><td> Bad Request: specific error details will be provided, if available </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td> Not Found: An associated legal person or workflow does not exist </td><td>  -  </td></tr>
            <tr><td> 409 </td><td> Conflict: An existing verification is in-flight </td><td>  -  </td></tr>
            <tr><td> 422 </td><td> Unprocessable Entity: specific error details will be provided, if available </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error: please contact support@griffin.com </td><td>  -  </td></tr>
            <tr><td> 502 </td><td> Bad Gateway: An error occurred with an external service integration </td><td>  -  </td></tr>
         </table>
         */
        public VerificationsInitiateVerificationResponse execute() throws ApiException {
            VerificationsInitiateVerificationRequest verificationsInitiateVerificationRequest = buildBodyParams();
            ApiResponse<VerificationsInitiateVerificationResponse> localVarResp = initiateVerificationWithHttpInfo(legalPersonId, verificationsInitiateVerificationRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute initiateVerification request with HTTP info returned
         * @return ApiResponse&lt;VerificationsInitiateVerificationResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> The created verification </td><td>  * Location - The URL to check the progress of the test <br>  </td></tr>
            <tr><td> 400 </td><td> Bad Request: specific error details will be provided, if available </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td> Not Found: An associated legal person or workflow does not exist </td><td>  -  </td></tr>
            <tr><td> 409 </td><td> Conflict: An existing verification is in-flight </td><td>  -  </td></tr>
            <tr><td> 422 </td><td> Unprocessable Entity: specific error details will be provided, if available </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error: please contact support@griffin.com </td><td>  -  </td></tr>
            <tr><td> 502 </td><td> Bad Gateway: An error occurred with an external service integration </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<VerificationsInitiateVerificationResponse> executeWithHttpInfo() throws ApiException {
            VerificationsInitiateVerificationRequest verificationsInitiateVerificationRequest = buildBodyParams();
            return initiateVerificationWithHttpInfo(legalPersonId, verificationsInitiateVerificationRequest);
        }

        /**
         * Execute initiateVerification request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> The created verification </td><td>  * Location - The URL to check the progress of the test <br>  </td></tr>
            <tr><td> 400 </td><td> Bad Request: specific error details will be provided, if available </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td> Not Found: An associated legal person or workflow does not exist </td><td>  -  </td></tr>
            <tr><td> 409 </td><td> Conflict: An existing verification is in-flight </td><td>  -  </td></tr>
            <tr><td> 422 </td><td> Unprocessable Entity: specific error details will be provided, if available </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error: please contact support@griffin.com </td><td>  -  </td></tr>
            <tr><td> 502 </td><td> Bad Gateway: An error occurred with an external service integration </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<VerificationsInitiateVerificationResponse> _callback) throws ApiException {
            VerificationsInitiateVerificationRequest verificationsInitiateVerificationRequest = buildBodyParams();
            return initiateVerificationAsync(legalPersonId, verificationsInitiateVerificationRequest, _callback);
        }
    }

    /**
     * Perform verification of a legal person
     * Initiates verification of the subject legal person.  The request body must include a &#x60;workflow-url&#x60; to determine checks to be performed by the verification. The workflow specified determines which claims must exist for the subject legal person, as identified in the request URL, and any associated legal persons (i.e. directors and people with significant control of a corporation).  These claims can be found in the &#x60;required-claim-types&#x60; field on a [Workflow](http://docs.griffin.com).  ---  Once a verification is created, the system will perform checks on the claim details. The status of check processing is indicated by the &#x60;verification-status&#x60; in the response body. Initially it will be &#x60;pending&#x60;, and will transition through &#x60;in-progress&#x60; to a final status of &#x60;checks-complete&#x60;.  A &#x60;verification-status&#x60; of &#x60;failed&#x60; indicates something went wrong during check processing. You can initiate another verification to retry the check processing.
     * @param legalPersonId  (required)
     * @param verificationsInitiateVerificationRequest  (required)
     * @return InitiateVerificationRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> The created verification </td><td>  * Location - The URL to check the progress of the test <br>  </td></tr>
        <tr><td> 400 </td><td> Bad Request: specific error details will be provided, if available </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
        <tr><td> 404 </td><td> Not Found: An associated legal person or workflow does not exist </td><td>  -  </td></tr>
        <tr><td> 409 </td><td> Conflict: An existing verification is in-flight </td><td>  -  </td></tr>
        <tr><td> 422 </td><td> Unprocessable Entity: specific error details will be provided, if available </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error: please contact support@griffin.com </td><td>  -  </td></tr>
        <tr><td> 502 </td><td> Bad Gateway: An error occurred with an external service integration </td><td>  -  </td></tr>
     </table>
     */
    public InitiateVerificationRequestBuilder initiateVerification(String workflowUrl, String legalPersonId) throws IllegalArgumentException {
        if (workflowUrl == null) throw new IllegalArgumentException("\"workflowUrl\" is required but got null");
            

        if (legalPersonId == null) throw new IllegalArgumentException("\"legalPersonId\" is required but got null");
            

        return new InitiateVerificationRequestBuilder(workflowUrl, legalPersonId);
    }
    private okhttp3.Call listForLegalPersonCall(String legalPersonId, String sort, Long pageSize, byte[] pageAfter, byte[] pageBefore, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v0/legal-persons/{legal-person-id}/verifications"
            .replace("{" + "legal-person-id" + "}", localVarApiClient.escapeString(legalPersonId.toString()));

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
    private okhttp3.Call listForLegalPersonValidateBeforeCall(String legalPersonId, String sort, Long pageSize, byte[] pageAfter, byte[] pageBefore, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'legalPersonId' is set
        if (legalPersonId == null) {
            throw new ApiException("Missing the required parameter 'legalPersonId' when calling listForLegalPerson(Async)");
        }

        return listForLegalPersonCall(legalPersonId, sort, pageSize, pageAfter, pageBefore, _callback);

    }


    private ApiResponse<VerificationsListForLegalPersonResponse> listForLegalPersonWithHttpInfo(String legalPersonId, String sort, Long pageSize, byte[] pageAfter, byte[] pageBefore) throws ApiException {
        okhttp3.Call localVarCall = listForLegalPersonValidateBeforeCall(legalPersonId, sort, pageSize, pageAfter, pageBefore, null);
        Type localVarReturnType = new TypeToken<VerificationsListForLegalPersonResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listForLegalPersonAsync(String legalPersonId, String sort, Long pageSize, byte[] pageAfter, byte[] pageBefore, final ApiCallback<VerificationsListForLegalPersonResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = listForLegalPersonValidateBeforeCall(legalPersonId, sort, pageSize, pageAfter, pageBefore, _callback);
        Type localVarReturnType = new TypeToken<VerificationsListForLegalPersonResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class ListForLegalPersonRequestBuilder {
        private final String legalPersonId;
        private String sort;
        private Long pageSize;
        private byte[] pageAfter;
        private byte[] pageBefore;

        private ListForLegalPersonRequestBuilder(String legalPersonId) {
            this.legalPersonId = legalPersonId;
        }

        /**
         * Set sort
         * @param sort  (optional)
         * @return ListForLegalPersonRequestBuilder
         */
        public ListForLegalPersonRequestBuilder sort(String sort) {
            this.sort = sort;
            return this;
        }
        
        /**
         * Set pageSize
         * @param pageSize  (optional)
         * @return ListForLegalPersonRequestBuilder
         */
        public ListForLegalPersonRequestBuilder pageSize(Long pageSize) {
            this.pageSize = pageSize;
            return this;
        }
        
        /**
         * Set pageAfter
         * @param pageAfter A base64 encoded opaque string returned in paginated responses. (optional)
         * @return ListForLegalPersonRequestBuilder
         */
        public ListForLegalPersonRequestBuilder pageAfter(byte[] pageAfter) {
            this.pageAfter = pageAfter;
            return this;
        }
        
        /**
         * Set pageBefore
         * @param pageBefore A base64 encoded opaque string returned in paginated responses. (optional)
         * @return ListForLegalPersonRequestBuilder
         */
        public ListForLegalPersonRequestBuilder pageBefore(byte[] pageBefore) {
            this.pageBefore = pageBefore;
            return this;
        }
        
        /**
         * Build call for listForLegalPerson
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return listForLegalPersonCall(legalPersonId, sort, pageSize, pageAfter, pageBefore, _callback);
        }


        /**
         * Execute listForLegalPerson request
         * @return VerificationsListForLegalPersonResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
         </table>
         */
        public VerificationsListForLegalPersonResponse execute() throws ApiException {
            ApiResponse<VerificationsListForLegalPersonResponse> localVarResp = listForLegalPersonWithHttpInfo(legalPersonId, sort, pageSize, pageAfter, pageBefore);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute listForLegalPerson request with HTTP info returned
         * @return ApiResponse&lt;VerificationsListForLegalPersonResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
         </table>
         */
        public ApiResponse<VerificationsListForLegalPersonResponse> executeWithHttpInfo() throws ApiException {
            return listForLegalPersonWithHttpInfo(legalPersonId, sort, pageSize, pageAfter, pageBefore);
        }

        /**
         * Execute listForLegalPerson request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<VerificationsListForLegalPersonResponse> _callback) throws ApiException {
            return listForLegalPersonAsync(legalPersonId, sort, pageSize, pageAfter, pageBefore, _callback);
        }
    }

    /**
     * List verifications for a legal person
     * List verifications for the given legal person.
     * @param legalPersonId  (required)
     * @return ListForLegalPersonRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
     </table>
     */
    public ListForLegalPersonRequestBuilder listForLegalPerson(String legalPersonId) throws IllegalArgumentException {
        if (legalPersonId == null) throw new IllegalArgumentException("\"legalPersonId\" is required but got null");
            

        return new ListForLegalPersonRequestBuilder(legalPersonId);
    }
}
