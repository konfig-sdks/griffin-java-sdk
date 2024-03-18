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


package com.konfigthis.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.konfigthis.client.JSON;

/**
 * NavigationGlobalPathsFetchResponse
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class NavigationGlobalPathsFetchResponse {
  public static final String SERIALIZED_NAME_ORGANIZATIONS_URL = "organizations-url";
  @SerializedName(SERIALIZED_NAME_ORGANIZATIONS_URL)
  private String organizationsUrl;

  public static final String SERIALIZED_NAME_USERS_URL = "users-url";
  @SerializedName(SERIALIZED_NAME_USERS_URL)
  private String usersUrl;

  public static final String SERIALIZED_NAME_ROLES_URL = "roles-url";
  @SerializedName(SERIALIZED_NAME_ROLES_URL)
  private String rolesUrl;

  public static final String SERIALIZED_NAME_SESSION_URL = "session-url";
  @SerializedName(SERIALIZED_NAME_SESSION_URL)
  private String sessionUrl;

  public static final String SERIALIZED_NAME_API_KEY_URL = "api-key-url";
  @SerializedName(SERIALIZED_NAME_API_KEY_URL)
  private String apiKeyUrl;

  public static final String SERIALIZED_NAME_ORGANIZATION_URL = "organization-url";
  @SerializedName(SERIALIZED_NAME_ORGANIZATION_URL)
  private String organizationUrl;

  public NavigationGlobalPathsFetchResponse() {
  }

  public NavigationGlobalPathsFetchResponse organizationsUrl(String organizationsUrl) {
    
    
    
    
    this.organizationsUrl = organizationsUrl;
    return this;
  }

   /**
   * Link to the [organization](http://docs.griffin.com).
   * @return organizationsUrl
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "/v0/organizations", required = true, value = "Link to the [organization](http://docs.griffin.com).")

  public String getOrganizationsUrl() {
    return organizationsUrl;
  }


  public void setOrganizationsUrl(String organizationsUrl) {
    
    
    
    this.organizationsUrl = organizationsUrl;
  }


  public NavigationGlobalPathsFetchResponse usersUrl(String usersUrl) {
    
    
    
    
    this.usersUrl = usersUrl;
    return this;
  }

   /**
   * Get usersUrl
   * @return usersUrl
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "/v0/users", required = true, value = "")

  public String getUsersUrl() {
    return usersUrl;
  }


  public void setUsersUrl(String usersUrl) {
    
    
    
    this.usersUrl = usersUrl;
  }


  public NavigationGlobalPathsFetchResponse rolesUrl(String rolesUrl) {
    
    
    
    
    this.rolesUrl = rolesUrl;
    return this;
  }

   /**
   * Get rolesUrl
   * @return rolesUrl
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "/v0/roles", required = true, value = "")

  public String getRolesUrl() {
    return rolesUrl;
  }


  public void setRolesUrl(String rolesUrl) {
    
    
    
    this.rolesUrl = rolesUrl;
  }


  public NavigationGlobalPathsFetchResponse sessionUrl(String sessionUrl) {
    
    
    
    
    this.sessionUrl = sessionUrl;
    return this;
  }

   /**
   * Get sessionUrl
   * @return sessionUrl
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "/v0/session", value = "")

  public String getSessionUrl() {
    return sessionUrl;
  }


  public void setSessionUrl(String sessionUrl) {
    
    
    
    this.sessionUrl = sessionUrl;
  }


  public NavigationGlobalPathsFetchResponse apiKeyUrl(String apiKeyUrl) {
    
    
    
    
    this.apiKeyUrl = apiKeyUrl;
    return this;
  }

   /**
   * The resource path for the API key
   * @return apiKeyUrl
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "/v0/api-keys/ak.ICAgICAgYXBpLWtleS1pZA", value = "The resource path for the API key")

  public String getApiKeyUrl() {
    return apiKeyUrl;
  }


  public void setApiKeyUrl(String apiKeyUrl) {
    
    
    
    this.apiKeyUrl = apiKeyUrl;
  }


  public NavigationGlobalPathsFetchResponse organizationUrl(String organizationUrl) {
    
    
    
    
    this.organizationUrl = organizationUrl;
    return this;
  }

   /**
   * Link to the [organization](http://docs.griffin.com).
   * @return organizationUrl
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "/v0/organizations/og.IG9yZ2FuaXphdGlvbi1pZA", value = "Link to the [organization](http://docs.griffin.com).")

  public String getOrganizationUrl() {
    return organizationUrl;
  }


  public void setOrganizationUrl(String organizationUrl) {
    
    
    
    this.organizationUrl = organizationUrl;
  }

  /**
   * A container for additional, undeclared properties.
   * This is a holder for any undeclared properties as specified with
   * the 'additionalProperties' keyword in the OAS document.
   */
  private Map<String, Object> additionalProperties;

  /**
   * Set the additional (undeclared) property with the specified name and value.
   * If the property does not already exist, create it otherwise replace it.
   *
   * @param key name of the property
   * @param value value of the property
   * @return the NavigationGlobalPathsFetchResponse instance itself
   */
  public NavigationGlobalPathsFetchResponse putAdditionalProperty(String key, Object value) {
    if (this.additionalProperties == null) {
        this.additionalProperties = new HashMap<String, Object>();
    }
    this.additionalProperties.put(key, value);
    return this;
  }

  /**
   * Return the additional (undeclared) property.
   *
   * @return a map of objects
   */
  public Map<String, Object> getAdditionalProperties() {
    return additionalProperties;
  }

  /**
   * Return the additional (undeclared) property with the specified name.
   *
   * @param key name of the property
   * @return an object
   */
  public Object getAdditionalProperty(String key) {
    if (this.additionalProperties == null) {
        return null;
    }
    return this.additionalProperties.get(key);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NavigationGlobalPathsFetchResponse navigationGlobalPathsFetchResponse = (NavigationGlobalPathsFetchResponse) o;
    return Objects.equals(this.organizationsUrl, navigationGlobalPathsFetchResponse.organizationsUrl) &&
        Objects.equals(this.usersUrl, navigationGlobalPathsFetchResponse.usersUrl) &&
        Objects.equals(this.rolesUrl, navigationGlobalPathsFetchResponse.rolesUrl) &&
        Objects.equals(this.sessionUrl, navigationGlobalPathsFetchResponse.sessionUrl) &&
        Objects.equals(this.apiKeyUrl, navigationGlobalPathsFetchResponse.apiKeyUrl) &&
        Objects.equals(this.organizationUrl, navigationGlobalPathsFetchResponse.organizationUrl)&&
        Objects.equals(this.additionalProperties, navigationGlobalPathsFetchResponse.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(organizationsUrl, usersUrl, rolesUrl, sessionUrl, apiKeyUrl, organizationUrl, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NavigationGlobalPathsFetchResponse {\n");
    sb.append("    organizationsUrl: ").append(toIndentedString(organizationsUrl)).append("\n");
    sb.append("    usersUrl: ").append(toIndentedString(usersUrl)).append("\n");
    sb.append("    rolesUrl: ").append(toIndentedString(rolesUrl)).append("\n");
    sb.append("    sessionUrl: ").append(toIndentedString(sessionUrl)).append("\n");
    sb.append("    apiKeyUrl: ").append(toIndentedString(apiKeyUrl)).append("\n");
    sb.append("    organizationUrl: ").append(toIndentedString(organizationUrl)).append("\n");
    sb.append("    additionalProperties: ").append(toIndentedString(additionalProperties)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("organizations-url");
    openapiFields.add("users-url");
    openapiFields.add("roles-url");
    openapiFields.add("session-url");
    openapiFields.add("api-key-url");
    openapiFields.add("organization-url");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("organizations-url");
    openapiRequiredFields.add("users-url");
    openapiRequiredFields.add("roles-url");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to NavigationGlobalPathsFetchResponse
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!NavigationGlobalPathsFetchResponse.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in NavigationGlobalPathsFetchResponse is not found in the empty JSON string", NavigationGlobalPathsFetchResponse.openapiRequiredFields.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : NavigationGlobalPathsFetchResponse.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if (!jsonObj.get("organizations-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `organizations-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("organizations-url").toString()));
      }
      if (!jsonObj.get("users-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `users-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("users-url").toString()));
      }
      if (!jsonObj.get("roles-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `roles-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("roles-url").toString()));
      }
      if ((jsonObj.get("session-url") != null && !jsonObj.get("session-url").isJsonNull()) && !jsonObj.get("session-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `session-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("session-url").toString()));
      }
      if ((jsonObj.get("api-key-url") != null && !jsonObj.get("api-key-url").isJsonNull()) && !jsonObj.get("api-key-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `api-key-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("api-key-url").toString()));
      }
      if ((jsonObj.get("organization-url") != null && !jsonObj.get("organization-url").isJsonNull()) && !jsonObj.get("organization-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `organization-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("organization-url").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!NavigationGlobalPathsFetchResponse.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'NavigationGlobalPathsFetchResponse' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<NavigationGlobalPathsFetchResponse> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(NavigationGlobalPathsFetchResponse.class));

       return (TypeAdapter<T>) new TypeAdapter<NavigationGlobalPathsFetchResponse>() {
           @Override
           public void write(JsonWriter out, NavigationGlobalPathsFetchResponse value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             obj.remove("additionalProperties");
             // serialize additonal properties
             if (value.getAdditionalProperties() != null) {
               for (Map.Entry<String, Object> entry : value.getAdditionalProperties().entrySet()) {
                 if (entry.getValue() instanceof String)
                   obj.addProperty(entry.getKey(), (String) entry.getValue());
                 else if (entry.getValue() instanceof Number)
                   obj.addProperty(entry.getKey(), (Number) entry.getValue());
                 else if (entry.getValue() instanceof Boolean)
                   obj.addProperty(entry.getKey(), (Boolean) entry.getValue());
                 else if (entry.getValue() instanceof Character)
                   obj.addProperty(entry.getKey(), (Character) entry.getValue());
                 else {
                   obj.add(entry.getKey(), gson.toJsonTree(entry.getValue()).getAsJsonObject());
                 }
               }
             }
             elementAdapter.write(out, obj);
           }

           @Override
           public NavigationGlobalPathsFetchResponse read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             NavigationGlobalPathsFetchResponse instance = thisAdapter.fromJsonTree(jsonObj);
             for (Map.Entry<String, JsonElement> entry : jsonObj.entrySet()) {
               if (!openapiFields.contains(entry.getKey())) {
                 if (entry.getValue().isJsonPrimitive()) { // primitive type
                   if (entry.getValue().getAsJsonPrimitive().isString())
                     instance.putAdditionalProperty(entry.getKey(), entry.getValue().getAsString());
                   else if (entry.getValue().getAsJsonPrimitive().isNumber())
                     instance.putAdditionalProperty(entry.getKey(), entry.getValue().getAsNumber());
                   else if (entry.getValue().getAsJsonPrimitive().isBoolean())
                     instance.putAdditionalProperty(entry.getKey(), entry.getValue().getAsBoolean());
                   else
                     throw new IllegalArgumentException(String.format("The field `%s` has unknown primitive type. Value: %s", entry.getKey(), entry.getValue().toString()));
                 } else if (entry.getValue().isJsonArray()) {
                     instance.putAdditionalProperty(entry.getKey(), gson.fromJson(entry.getValue(), List.class));
                 } else { // JSON object
                     instance.putAdditionalProperty(entry.getKey(), gson.fromJson(entry.getValue(), HashMap.class));
                 }
               }
             }
             return instance;
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of NavigationGlobalPathsFetchResponse given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of NavigationGlobalPathsFetchResponse
  * @throws IOException if the JSON string is invalid with respect to NavigationGlobalPathsFetchResponse
  */
  public static NavigationGlobalPathsFetchResponse fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, NavigationGlobalPathsFetchResponse.class);
  }

 /**
  * Convert an instance of NavigationGlobalPathsFetchResponse to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

