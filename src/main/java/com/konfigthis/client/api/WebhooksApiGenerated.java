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


import com.konfigthis.client.model.WebhooksActivateActionResponse;
import com.konfigthis.client.model.WebhooksCreateWebhookRequest;
import com.konfigthis.client.model.WebhooksCreateWebhookResponse;
import com.konfigthis.client.model.WebhooksDeactivateActionResponse;
import com.konfigthis.client.model.WebhooksGetAllResponse;
import com.konfigthis.client.model.WebhooksGetLatestTestStatusResponse;
import com.konfigthis.client.model.WebhooksGetWebhookResponse;
import com.konfigthis.client.model.WebhooksSendTestEventResponse;
import com.konfigthis.client.model.WebhooksUpdateWebhookRequest;
import com.konfigthis.client.model.WebhooksUpdateWebhookResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;

public class WebhooksApiGenerated {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public WebhooksApiGenerated() throws IllegalArgumentException {
        this(Configuration.getDefaultApiClient());
    }

    public WebhooksApiGenerated(ApiClient apiClient) throws IllegalArgumentException {
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

    private okhttp3.Call activateActionCall(String webhookId, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v0/webhooks/{webhook-id}/actions/activate"
            .replace("{" + "webhook-id" + "}", localVarApiClient.escapeString(webhookId.toString()));

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
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call activateActionValidateBeforeCall(String webhookId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'webhookId' is set
        if (webhookId == null) {
            throw new ApiException("Missing the required parameter 'webhookId' when calling activateAction(Async)");
        }

        return activateActionCall(webhookId, _callback);

    }


    private ApiResponse<WebhooksActivateActionResponse> activateActionWithHttpInfo(String webhookId) throws ApiException {
        okhttp3.Call localVarCall = activateActionValidateBeforeCall(webhookId, null);
        Type localVarReturnType = new TypeToken<WebhooksActivateActionResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call activateActionAsync(String webhookId, final ApiCallback<WebhooksActivateActionResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = activateActionValidateBeforeCall(webhookId, _callback);
        Type localVarReturnType = new TypeToken<WebhooksActivateActionResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class ActivateActionRequestBuilder {
        private final String webhookId;

        private ActivateActionRequestBuilder(String webhookId) {
            this.webhookId = webhookId;
        }

        /**
         * Build call for activateAction
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
            return activateActionCall(webhookId, _callback);
        }


        /**
         * Execute activateAction request
         * @return WebhooksActivateActionResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public WebhooksActivateActionResponse execute() throws ApiException {
            ApiResponse<WebhooksActivateActionResponse> localVarResp = activateActionWithHttpInfo(webhookId);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute activateAction request with HTTP info returned
         * @return ApiResponse&lt;WebhooksActivateActionResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<WebhooksActivateActionResponse> executeWithHttpInfo() throws ApiException {
            return activateActionWithHttpInfo(webhookId);
        }

        /**
         * Execute activateAction request (asynchronously)
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
        public okhttp3.Call executeAsync(final ApiCallback<WebhooksActivateActionResponse> _callback) throws ApiException {
            return activateActionAsync(webhookId, _callback);
        }
    }

    /**
     * 
     * Activate a webhook
     * @param webhookId  (required)
     * @return ActivateActionRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
        <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public ActivateActionRequestBuilder activateAction(String webhookId) throws IllegalArgumentException {
        if (webhookId == null) throw new IllegalArgumentException("\"webhookId\" is required but got null");
            

        return new ActivateActionRequestBuilder(webhookId);
    }
    private okhttp3.Call createWebhookCall(String organizationId, WebhooksCreateWebhookRequest webhooksCreateWebhookRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = webhooksCreateWebhookRequest;

        // create path and map variables
        String localVarPath = "/v0/organizations/{organization-id}/webhooks"
            .replace("{" + "organization-id" + "}", localVarApiClient.escapeString(organizationId.toString()));

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
    private okhttp3.Call createWebhookValidateBeforeCall(String organizationId, WebhooksCreateWebhookRequest webhooksCreateWebhookRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling createWebhook(Async)");
        }

        // verify the required parameter 'webhooksCreateWebhookRequest' is set
        if (webhooksCreateWebhookRequest == null) {
            throw new ApiException("Missing the required parameter 'webhooksCreateWebhookRequest' when calling createWebhook(Async)");
        }

        return createWebhookCall(organizationId, webhooksCreateWebhookRequest, _callback);

    }


    private ApiResponse<WebhooksCreateWebhookResponse> createWebhookWithHttpInfo(String organizationId, WebhooksCreateWebhookRequest webhooksCreateWebhookRequest) throws ApiException {
        okhttp3.Call localVarCall = createWebhookValidateBeforeCall(organizationId, webhooksCreateWebhookRequest, null);
        Type localVarReturnType = new TypeToken<WebhooksCreateWebhookResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call createWebhookAsync(String organizationId, WebhooksCreateWebhookRequest webhooksCreateWebhookRequest, final ApiCallback<WebhooksCreateWebhookResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = createWebhookValidateBeforeCall(organizationId, webhooksCreateWebhookRequest, _callback);
        Type localVarReturnType = new TypeToken<WebhooksCreateWebhookResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class CreateWebhookRequestBuilder {
        private final String webhookDestinationUrl;
        private final String organizationId;
        private String webhookDescription;

        private CreateWebhookRequestBuilder(String webhookDestinationUrl, String organizationId) {
            this.webhookDestinationUrl = webhookDestinationUrl;
            this.organizationId = organizationId;
        }

        /**
         * Set webhookDescription
         * @param webhookDescription A description of the webhook (optional)
         * @return CreateWebhookRequestBuilder
         */
        public CreateWebhookRequestBuilder webhookDescription(String webhookDescription) {
            this.webhookDescription = webhookDescription;
            return this;
        }
        
        /**
         * Build call for createWebhook
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> The newly-created webhook </td><td>  * Location - The URL to check the progress of the test <br>  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 422 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            WebhooksCreateWebhookRequest webhooksCreateWebhookRequest = buildBodyParams();
            return createWebhookCall(organizationId, webhooksCreateWebhookRequest, _callback);
        }

        private WebhooksCreateWebhookRequest buildBodyParams() {
            WebhooksCreateWebhookRequest webhooksCreateWebhookRequest = new WebhooksCreateWebhookRequest();
            webhooksCreateWebhookRequest.webhookDestinationUrl(this.webhookDestinationUrl);
            webhooksCreateWebhookRequest.webhookDescription(this.webhookDescription);
            return webhooksCreateWebhookRequest;
        }

        /**
         * Execute createWebhook request
         * @return WebhooksCreateWebhookResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> The newly-created webhook </td><td>  * Location - The URL to check the progress of the test <br>  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 422 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public WebhooksCreateWebhookResponse execute() throws ApiException {
            WebhooksCreateWebhookRequest webhooksCreateWebhookRequest = buildBodyParams();
            ApiResponse<WebhooksCreateWebhookResponse> localVarResp = createWebhookWithHttpInfo(organizationId, webhooksCreateWebhookRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute createWebhook request with HTTP info returned
         * @return ApiResponse&lt;WebhooksCreateWebhookResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> The newly-created webhook </td><td>  * Location - The URL to check the progress of the test <br>  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 422 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<WebhooksCreateWebhookResponse> executeWithHttpInfo() throws ApiException {
            WebhooksCreateWebhookRequest webhooksCreateWebhookRequest = buildBodyParams();
            return createWebhookWithHttpInfo(organizationId, webhooksCreateWebhookRequest);
        }

        /**
         * Execute createWebhook request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> The newly-created webhook </td><td>  * Location - The URL to check the progress of the test <br>  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 422 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<WebhooksCreateWebhookResponse> _callback) throws ApiException {
            WebhooksCreateWebhookRequest webhooksCreateWebhookRequest = buildBodyParams();
            return createWebhookAsync(organizationId, webhooksCreateWebhookRequest, _callback);
        }
    }

    /**
     * 
     * Create a webhook
     * @param organizationId  (required)
     * @param webhooksCreateWebhookRequest  (required)
     * @return CreateWebhookRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> The newly-created webhook </td><td>  * Location - The URL to check the progress of the test <br>  </td></tr>
        <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
        <tr><td> 422 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public CreateWebhookRequestBuilder createWebhook(String webhookDestinationUrl, String organizationId) throws IllegalArgumentException {
        if (webhookDestinationUrl == null) throw new IllegalArgumentException("\"webhookDestinationUrl\" is required but got null");
            

        if (organizationId == null) throw new IllegalArgumentException("\"organizationId\" is required but got null");
            

        return new CreateWebhookRequestBuilder(webhookDestinationUrl, organizationId);
    }
    private okhttp3.Call deactivateActionCall(String webhookId, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v0/webhooks/{webhook-id}/actions/deactivate"
            .replace("{" + "webhook-id" + "}", localVarApiClient.escapeString(webhookId.toString()));

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
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call deactivateActionValidateBeforeCall(String webhookId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'webhookId' is set
        if (webhookId == null) {
            throw new ApiException("Missing the required parameter 'webhookId' when calling deactivateAction(Async)");
        }

        return deactivateActionCall(webhookId, _callback);

    }


    private ApiResponse<WebhooksDeactivateActionResponse> deactivateActionWithHttpInfo(String webhookId) throws ApiException {
        okhttp3.Call localVarCall = deactivateActionValidateBeforeCall(webhookId, null);
        Type localVarReturnType = new TypeToken<WebhooksDeactivateActionResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call deactivateActionAsync(String webhookId, final ApiCallback<WebhooksDeactivateActionResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = deactivateActionValidateBeforeCall(webhookId, _callback);
        Type localVarReturnType = new TypeToken<WebhooksDeactivateActionResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class DeactivateActionRequestBuilder {
        private final String webhookId;

        private DeactivateActionRequestBuilder(String webhookId) {
            this.webhookId = webhookId;
        }

        /**
         * Build call for deactivateAction
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
            return deactivateActionCall(webhookId, _callback);
        }


        /**
         * Execute deactivateAction request
         * @return WebhooksDeactivateActionResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public WebhooksDeactivateActionResponse execute() throws ApiException {
            ApiResponse<WebhooksDeactivateActionResponse> localVarResp = deactivateActionWithHttpInfo(webhookId);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute deactivateAction request with HTTP info returned
         * @return ApiResponse&lt;WebhooksDeactivateActionResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<WebhooksDeactivateActionResponse> executeWithHttpInfo() throws ApiException {
            return deactivateActionWithHttpInfo(webhookId);
        }

        /**
         * Execute deactivateAction request (asynchronously)
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
        public okhttp3.Call executeAsync(final ApiCallback<WebhooksDeactivateActionResponse> _callback) throws ApiException {
            return deactivateActionAsync(webhookId, _callback);
        }
    }

    /**
     * 
     * Deactivate a webhook
     * @param webhookId  (required)
     * @return DeactivateActionRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
        <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public DeactivateActionRequestBuilder deactivateAction(String webhookId) throws IllegalArgumentException {
        if (webhookId == null) throw new IllegalArgumentException("\"webhookId\" is required but got null");
            

        return new DeactivateActionRequestBuilder(webhookId);
    }
    private okhttp3.Call deleteWebhookCall(String webhookId, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v0/webhooks/{webhook-id}"
            .replace("{" + "webhook-id" + "}", localVarApiClient.escapeString(webhookId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
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
        return localVarApiClient.buildCall(basePath, localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call deleteWebhookValidateBeforeCall(String webhookId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'webhookId' is set
        if (webhookId == null) {
            throw new ApiException("Missing the required parameter 'webhookId' when calling deleteWebhook(Async)");
        }

        return deleteWebhookCall(webhookId, _callback);

    }


    private ApiResponse<Void> deleteWebhookWithHttpInfo(String webhookId) throws ApiException {
        okhttp3.Call localVarCall = deleteWebhookValidateBeforeCall(webhookId, null);
        return localVarApiClient.execute(localVarCall);
    }

    private okhttp3.Call deleteWebhookAsync(String webhookId, final ApiCallback<Void> _callback) throws ApiException {

        okhttp3.Call localVarCall = deleteWebhookValidateBeforeCall(webhookId, _callback);
        localVarApiClient.executeAsync(localVarCall, _callback);
        return localVarCall;
    }

    public class DeleteWebhookRequestBuilder {
        private final String webhookId;

        private DeleteWebhookRequestBuilder(String webhookId) {
            this.webhookId = webhookId;
        }

        /**
         * Build call for deleteWebhook
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 204 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return deleteWebhookCall(webhookId, _callback);
        }


        /**
         * Execute deleteWebhook request
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 204 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public void execute() throws ApiException {
            deleteWebhookWithHttpInfo(webhookId);
        }

        /**
         * Execute deleteWebhook request with HTTP info returned
         * @return ApiResponse&lt;Void&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 204 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<Void> executeWithHttpInfo() throws ApiException {
            return deleteWebhookWithHttpInfo(webhookId);
        }

        /**
         * Execute deleteWebhook request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 204 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<Void> _callback) throws ApiException {
            return deleteWebhookAsync(webhookId, _callback);
        }
    }

    /**
     * 
     * Delete a webhook
     * @param webhookId  (required)
     * @return DeleteWebhookRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 204 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
        <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public DeleteWebhookRequestBuilder deleteWebhook(String webhookId) throws IllegalArgumentException {
        if (webhookId == null) throw new IllegalArgumentException("\"webhookId\" is required but got null");
            

        return new DeleteWebhookRequestBuilder(webhookId);
    }
    private okhttp3.Call getAllCall(String organizationId, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v0/organizations/{organization-id}/webhooks"
            .replace("{" + "organization-id" + "}", localVarApiClient.escapeString(organizationId.toString()));

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
    private okhttp3.Call getAllValidateBeforeCall(String organizationId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'organizationId' is set
        if (organizationId == null) {
            throw new ApiException("Missing the required parameter 'organizationId' when calling getAll(Async)");
        }

        return getAllCall(organizationId, _callback);

    }


    private ApiResponse<WebhooksGetAllResponse> getAllWithHttpInfo(String organizationId) throws ApiException {
        okhttp3.Call localVarCall = getAllValidateBeforeCall(organizationId, null);
        Type localVarReturnType = new TypeToken<WebhooksGetAllResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getAllAsync(String organizationId, final ApiCallback<WebhooksGetAllResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = getAllValidateBeforeCall(organizationId, _callback);
        Type localVarReturnType = new TypeToken<WebhooksGetAllResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class GetAllRequestBuilder {
        private final String organizationId;

        private GetAllRequestBuilder(String organizationId) {
            this.organizationId = organizationId;
        }

        /**
         * Build call for getAll
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
            return getAllCall(organizationId, _callback);
        }


        /**
         * Execute getAll request
         * @return WebhooksGetAllResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
         </table>
         */
        public WebhooksGetAllResponse execute() throws ApiException {
            ApiResponse<WebhooksGetAllResponse> localVarResp = getAllWithHttpInfo(organizationId);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute getAll request with HTTP info returned
         * @return ApiResponse&lt;WebhooksGetAllResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
         </table>
         */
        public ApiResponse<WebhooksGetAllResponse> executeWithHttpInfo() throws ApiException {
            return getAllWithHttpInfo(organizationId);
        }

        /**
         * Execute getAll request (asynchronously)
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
        public okhttp3.Call executeAsync(final ApiCallback<WebhooksGetAllResponse> _callback) throws ApiException {
            return getAllAsync(organizationId, _callback);
        }
    }

    /**
     * 
     * Get all webhooks for the organization
     * @param organizationId  (required)
     * @return GetAllRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
     </table>
     */
    public GetAllRequestBuilder getAll(String organizationId) throws IllegalArgumentException {
        if (organizationId == null) throw new IllegalArgumentException("\"organizationId\" is required but got null");
            

        return new GetAllRequestBuilder(organizationId);
    }
    private okhttp3.Call getLatestTestStatusCall(String webhookId, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v0/webhooks/{webhook-id}/actions/test"
            .replace("{" + "webhook-id" + "}", localVarApiClient.escapeString(webhookId.toString()));

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
    private okhttp3.Call getLatestTestStatusValidateBeforeCall(String webhookId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'webhookId' is set
        if (webhookId == null) {
            throw new ApiException("Missing the required parameter 'webhookId' when calling getLatestTestStatus(Async)");
        }

        return getLatestTestStatusCall(webhookId, _callback);

    }


    private ApiResponse<WebhooksGetLatestTestStatusResponse> getLatestTestStatusWithHttpInfo(String webhookId) throws ApiException {
        okhttp3.Call localVarCall = getLatestTestStatusValidateBeforeCall(webhookId, null);
        Type localVarReturnType = new TypeToken<WebhooksGetLatestTestStatusResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getLatestTestStatusAsync(String webhookId, final ApiCallback<WebhooksGetLatestTestStatusResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = getLatestTestStatusValidateBeforeCall(webhookId, _callback);
        Type localVarReturnType = new TypeToken<WebhooksGetLatestTestStatusResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class GetLatestTestStatusRequestBuilder {
        private final String webhookId;

        private GetLatestTestStatusRequestBuilder(String webhookId) {
            this.webhookId = webhookId;
        }

        /**
         * Build call for getLatestTestStatus
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
            return getLatestTestStatusCall(webhookId, _callback);
        }


        /**
         * Execute getLatestTestStatus request
         * @return WebhooksGetLatestTestStatusResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public WebhooksGetLatestTestStatusResponse execute() throws ApiException {
            ApiResponse<WebhooksGetLatestTestStatusResponse> localVarResp = getLatestTestStatusWithHttpInfo(webhookId);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute getLatestTestStatus request with HTTP info returned
         * @return ApiResponse&lt;WebhooksGetLatestTestStatusResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<WebhooksGetLatestTestStatusResponse> executeWithHttpInfo() throws ApiException {
            return getLatestTestStatusWithHttpInfo(webhookId);
        }

        /**
         * Execute getLatestTestStatus request (asynchronously)
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
        public okhttp3.Call executeAsync(final ApiCallback<WebhooksGetLatestTestStatusResponse> _callback) throws ApiException {
            return getLatestTestStatusAsync(webhookId, _callback);
        }
    }

    /**
     * 
     * Get the status of the latest test event
     * @param webhookId  (required)
     * @return GetLatestTestStatusRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
        <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public GetLatestTestStatusRequestBuilder getLatestTestStatus(String webhookId) throws IllegalArgumentException {
        if (webhookId == null) throw new IllegalArgumentException("\"webhookId\" is required but got null");
            

        return new GetLatestTestStatusRequestBuilder(webhookId);
    }
    private okhttp3.Call getWebhookCall(String webhookId, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v0/webhooks/{webhook-id}"
            .replace("{" + "webhook-id" + "}", localVarApiClient.escapeString(webhookId.toString()));

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
    private okhttp3.Call getWebhookValidateBeforeCall(String webhookId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'webhookId' is set
        if (webhookId == null) {
            throw new ApiException("Missing the required parameter 'webhookId' when calling getWebhook(Async)");
        }

        return getWebhookCall(webhookId, _callback);

    }


    private ApiResponse<WebhooksGetWebhookResponse> getWebhookWithHttpInfo(String webhookId) throws ApiException {
        okhttp3.Call localVarCall = getWebhookValidateBeforeCall(webhookId, null);
        Type localVarReturnType = new TypeToken<WebhooksGetWebhookResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getWebhookAsync(String webhookId, final ApiCallback<WebhooksGetWebhookResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = getWebhookValidateBeforeCall(webhookId, _callback);
        Type localVarReturnType = new TypeToken<WebhooksGetWebhookResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class GetWebhookRequestBuilder {
        private final String webhookId;

        private GetWebhookRequestBuilder(String webhookId) {
            this.webhookId = webhookId;
        }

        /**
         * Build call for getWebhook
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
            return getWebhookCall(webhookId, _callback);
        }


        /**
         * Execute getWebhook request
         * @return WebhooksGetWebhookResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public WebhooksGetWebhookResponse execute() throws ApiException {
            ApiResponse<WebhooksGetWebhookResponse> localVarResp = getWebhookWithHttpInfo(webhookId);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute getWebhook request with HTTP info returned
         * @return ApiResponse&lt;WebhooksGetWebhookResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<WebhooksGetWebhookResponse> executeWithHttpInfo() throws ApiException {
            return getWebhookWithHttpInfo(webhookId);
        }

        /**
         * Execute getWebhook request (asynchronously)
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
        public okhttp3.Call executeAsync(final ApiCallback<WebhooksGetWebhookResponse> _callback) throws ApiException {
            return getWebhookAsync(webhookId, _callback);
        }
    }

    /**
     * 
     * Fetch a webhook
     * @param webhookId  (required)
     * @return GetWebhookRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
        <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public GetWebhookRequestBuilder getWebhook(String webhookId) throws IllegalArgumentException {
        if (webhookId == null) throw new IllegalArgumentException("\"webhookId\" is required but got null");
            

        return new GetWebhookRequestBuilder(webhookId);
    }
    private okhttp3.Call sendTestEventCall(String webhookId, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v0/webhooks/{webhook-id}/actions/test"
            .replace("{" + "webhook-id" + "}", localVarApiClient.escapeString(webhookId.toString()));

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
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call sendTestEventValidateBeforeCall(String webhookId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'webhookId' is set
        if (webhookId == null) {
            throw new ApiException("Missing the required parameter 'webhookId' when calling sendTestEvent(Async)");
        }

        return sendTestEventCall(webhookId, _callback);

    }


    private ApiResponse<WebhooksSendTestEventResponse> sendTestEventWithHttpInfo(String webhookId) throws ApiException {
        okhttp3.Call localVarCall = sendTestEventValidateBeforeCall(webhookId, null);
        Type localVarReturnType = new TypeToken<WebhooksSendTestEventResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call sendTestEventAsync(String webhookId, final ApiCallback<WebhooksSendTestEventResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = sendTestEventValidateBeforeCall(webhookId, _callback);
        Type localVarReturnType = new TypeToken<WebhooksSendTestEventResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class SendTestEventRequestBuilder {
        private final String webhookId;

        private SendTestEventRequestBuilder(String webhookId) {
            this.webhookId = webhookId;
        }

        /**
         * Build call for sendTestEvent
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td>  </td><td>  * Location - The URL to check the progress of the test <br>  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 409 </td><td> An existing test is in-flight </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return sendTestEventCall(webhookId, _callback);
        }


        /**
         * Execute sendTestEvent request
         * @return WebhooksSendTestEventResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td>  </td><td>  * Location - The URL to check the progress of the test <br>  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 409 </td><td> An existing test is in-flight </td><td>  -  </td></tr>
         </table>
         */
        public WebhooksSendTestEventResponse execute() throws ApiException {
            ApiResponse<WebhooksSendTestEventResponse> localVarResp = sendTestEventWithHttpInfo(webhookId);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute sendTestEvent request with HTTP info returned
         * @return ApiResponse&lt;WebhooksSendTestEventResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td>  </td><td>  * Location - The URL to check the progress of the test <br>  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 409 </td><td> An existing test is in-flight </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<WebhooksSendTestEventResponse> executeWithHttpInfo() throws ApiException {
            return sendTestEventWithHttpInfo(webhookId);
        }

        /**
         * Execute sendTestEvent request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td>  </td><td>  * Location - The URL to check the progress of the test <br>  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 409 </td><td> An existing test is in-flight </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<WebhooksSendTestEventResponse> _callback) throws ApiException {
            return sendTestEventAsync(webhookId, _callback);
        }
    }

    /**
     * 
     * Send a test event to the webhook
     * @param webhookId  (required)
     * @return SendTestEventRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td>  </td><td>  * Location - The URL to check the progress of the test <br>  </td></tr>
        <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
        <tr><td> 409 </td><td> An existing test is in-flight </td><td>  -  </td></tr>
     </table>
     */
    public SendTestEventRequestBuilder sendTestEvent(String webhookId) throws IllegalArgumentException {
        if (webhookId == null) throw new IllegalArgumentException("\"webhookId\" is required but got null");
            

        return new SendTestEventRequestBuilder(webhookId);
    }
    private okhttp3.Call updateWebhookCall(String webhookId, WebhooksUpdateWebhookRequest webhooksUpdateWebhookRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = webhooksUpdateWebhookRequest;

        // create path and map variables
        String localVarPath = "/v0/webhooks/{webhook-id}"
            .replace("{" + "webhook-id" + "}", localVarApiClient.escapeString(webhookId.toString()));

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
        return localVarApiClient.buildCall(basePath, localVarPath, "PATCH", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call updateWebhookValidateBeforeCall(String webhookId, WebhooksUpdateWebhookRequest webhooksUpdateWebhookRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'webhookId' is set
        if (webhookId == null) {
            throw new ApiException("Missing the required parameter 'webhookId' when calling updateWebhook(Async)");
        }

        // verify the required parameter 'webhooksUpdateWebhookRequest' is set
        if (webhooksUpdateWebhookRequest == null) {
            throw new ApiException("Missing the required parameter 'webhooksUpdateWebhookRequest' when calling updateWebhook(Async)");
        }

        return updateWebhookCall(webhookId, webhooksUpdateWebhookRequest, _callback);

    }


    private ApiResponse<WebhooksUpdateWebhookResponse> updateWebhookWithHttpInfo(String webhookId, WebhooksUpdateWebhookRequest webhooksUpdateWebhookRequest) throws ApiException {
        okhttp3.Call localVarCall = updateWebhookValidateBeforeCall(webhookId, webhooksUpdateWebhookRequest, null);
        Type localVarReturnType = new TypeToken<WebhooksUpdateWebhookResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call updateWebhookAsync(String webhookId, WebhooksUpdateWebhookRequest webhooksUpdateWebhookRequest, final ApiCallback<WebhooksUpdateWebhookResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = updateWebhookValidateBeforeCall(webhookId, webhooksUpdateWebhookRequest, _callback);
        Type localVarReturnType = new TypeToken<WebhooksUpdateWebhookResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class UpdateWebhookRequestBuilder {
        private final String webhookId;
        private String webhookDescription;

        private UpdateWebhookRequestBuilder(String webhookId) {
            this.webhookId = webhookId;
        }

        /**
         * Set webhookDescription
         * @param webhookDescription A description of the webhook (optional)
         * @return UpdateWebhookRequestBuilder
         */
        public UpdateWebhookRequestBuilder webhookDescription(String webhookDescription) {
            this.webhookDescription = webhookDescription;
            return this;
        }
        
        /**
         * Build call for updateWebhook
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
            WebhooksUpdateWebhookRequest webhooksUpdateWebhookRequest = buildBodyParams();
            return updateWebhookCall(webhookId, webhooksUpdateWebhookRequest, _callback);
        }

        private WebhooksUpdateWebhookRequest buildBodyParams() {
            WebhooksUpdateWebhookRequest webhooksUpdateWebhookRequest = new WebhooksUpdateWebhookRequest();
            webhooksUpdateWebhookRequest.webhookDescription(this.webhookDescription);
            return webhooksUpdateWebhookRequest;
        }

        /**
         * Execute updateWebhook request
         * @return WebhooksUpdateWebhookResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public WebhooksUpdateWebhookResponse execute() throws ApiException {
            WebhooksUpdateWebhookRequest webhooksUpdateWebhookRequest = buildBodyParams();
            ApiResponse<WebhooksUpdateWebhookResponse> localVarResp = updateWebhookWithHttpInfo(webhookId, webhooksUpdateWebhookRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute updateWebhook request with HTTP info returned
         * @return ApiResponse&lt;WebhooksUpdateWebhookResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
            <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
            <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<WebhooksUpdateWebhookResponse> executeWithHttpInfo() throws ApiException {
            WebhooksUpdateWebhookRequest webhooksUpdateWebhookRequest = buildBodyParams();
            return updateWebhookWithHttpInfo(webhookId, webhooksUpdateWebhookRequest);
        }

        /**
         * Execute updateWebhook request (asynchronously)
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
        public okhttp3.Call executeAsync(final ApiCallback<WebhooksUpdateWebhookResponse> _callback) throws ApiException {
            WebhooksUpdateWebhookRequest webhooksUpdateWebhookRequest = buildBodyParams();
            return updateWebhookAsync(webhookId, webhooksUpdateWebhookRequest, _callback);
        }
    }

    /**
     * 
     * Update a webhook
     * @param webhookId  (required)
     * @param webhooksUpdateWebhookRequest  (required)
     * @return UpdateWebhookRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> Requires an API key to continue </td><td>  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  </td></tr>
        <tr><td> 404 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public UpdateWebhookRequestBuilder updateWebhook(String webhookId) throws IllegalArgumentException {
        if (webhookId == null) throw new IllegalArgumentException("\"webhookId\" is required but got null");
            

        return new UpdateWebhookRequestBuilder(webhookId);
    }
}
