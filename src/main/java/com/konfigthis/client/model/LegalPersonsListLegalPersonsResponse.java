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
import com.konfigthis.client.model.LegalPerson2;
import com.konfigthis.client.model.LinksProperty;
import com.konfigthis.client.model.MetaProperty;
import com.konfigthis.client.model.Property3;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * LegalPersonsListLegalPersonsResponse
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class LegalPersonsListLegalPersonsResponse {
  public static final String SERIALIZED_NAME_LEGAL_PERSONS = "legal-persons";
  @SerializedName(SERIALIZED_NAME_LEGAL_PERSONS)
  private List<LegalPerson2> legalPersons = new ArrayList<>();

  public static final String SERIALIZED_NAME_LINKS = "links";
  @SerializedName(SERIALIZED_NAME_LINKS)
  private LinksProperty links;

  public static final String SERIALIZED_NAME_META = "meta";
  @SerializedName(SERIALIZED_NAME_META)
  private MetaProperty meta;

  public static final String SERIALIZED_NAME_INCLUDED = "included";
  @SerializedName(SERIALIZED_NAME_INCLUDED)
  private Property3 included;

  public LegalPersonsListLegalPersonsResponse() {
  }

  public LegalPersonsListLegalPersonsResponse legalPersons(List<LegalPerson2> legalPersons) {
    
    
    
    
    this.legalPersons = legalPersons;
    return this;
  }

  public LegalPersonsListLegalPersonsResponse addLegalPersonsItem(LegalPerson2 legalPersonsItem) {
    this.legalPersons.add(legalPersonsItem);
    return this;
  }

   /**
   * Get legalPersons
   * @return legalPersons
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public List<LegalPerson2> getLegalPersons() {
    return legalPersons;
  }


  public void setLegalPersons(List<LegalPerson2> legalPersons) {
    
    
    
    this.legalPersons = legalPersons;
  }


  public LegalPersonsListLegalPersonsResponse links(LinksProperty links) {
    
    
    
    
    this.links = links;
    return this;
  }

   /**
   * Get links
   * @return links
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public LinksProperty getLinks() {
    return links;
  }


  public void setLinks(LinksProperty links) {
    
    
    
    this.links = links;
  }


  public LegalPersonsListLegalPersonsResponse meta(MetaProperty meta) {
    
    
    
    
    this.meta = meta;
    return this;
  }

   /**
   * Get meta
   * @return meta
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public MetaProperty getMeta() {
    return meta;
  }


  public void setMeta(MetaProperty meta) {
    
    
    
    this.meta = meta;
  }


  public LegalPersonsListLegalPersonsResponse included(Property3 included) {
    
    
    
    
    this.included = included;
    return this;
  }

   /**
   * Get included
   * @return included
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Property3 getIncluded() {
    return included;
  }


  public void setIncluded(Property3 included) {
    
    
    
    this.included = included;
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
   * @return the LegalPersonsListLegalPersonsResponse instance itself
   */
  public LegalPersonsListLegalPersonsResponse putAdditionalProperty(String key, Object value) {
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
    LegalPersonsListLegalPersonsResponse legalPersonsListLegalPersonsResponse = (LegalPersonsListLegalPersonsResponse) o;
    return Objects.equals(this.legalPersons, legalPersonsListLegalPersonsResponse.legalPersons) &&
        Objects.equals(this.links, legalPersonsListLegalPersonsResponse.links) &&
        Objects.equals(this.meta, legalPersonsListLegalPersonsResponse.meta) &&
        Objects.equals(this.included, legalPersonsListLegalPersonsResponse.included)&&
        Objects.equals(this.additionalProperties, legalPersonsListLegalPersonsResponse.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(legalPersons, links, meta, included, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LegalPersonsListLegalPersonsResponse {\n");
    sb.append("    legalPersons: ").append(toIndentedString(legalPersons)).append("\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
    sb.append("    meta: ").append(toIndentedString(meta)).append("\n");
    sb.append("    included: ").append(toIndentedString(included)).append("\n");
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
    openapiFields.add("legal-persons");
    openapiFields.add("links");
    openapiFields.add("meta");
    openapiFields.add("included");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("legal-persons");
    openapiRequiredFields.add("links");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to LegalPersonsListLegalPersonsResponse
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!LegalPersonsListLegalPersonsResponse.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in LegalPersonsListLegalPersonsResponse is not found in the empty JSON string", LegalPersonsListLegalPersonsResponse.openapiRequiredFields.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : LegalPersonsListLegalPersonsResponse.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      // ensure the json data is an array
      if (!jsonObj.get("legal-persons").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `legal-persons` to be an array in the JSON string but got `%s`", jsonObj.get("legal-persons").toString()));
      }

      JsonArray jsonArraylegalPersons = jsonObj.getAsJsonArray("legal-persons");
      // validate the required field `legal-persons` (array)
      for (int i = 0; i < jsonArraylegalPersons.size(); i++) {
        LegalPerson2.validateJsonObject(jsonArraylegalPersons.get(i).getAsJsonObject());
      };
      // validate the required field `links`
      LinksProperty.validateJsonObject(jsonObj.getAsJsonObject("links"));
      // validate the optional field `meta`
      if (jsonObj.get("meta") != null && !jsonObj.get("meta").isJsonNull()) {
        MetaProperty.validateJsonObject(jsonObj.getAsJsonObject("meta"));
      }
      // validate the optional field `included`
      if (jsonObj.get("included") != null && !jsonObj.get("included").isJsonNull()) {
        Property3.validateJsonObject(jsonObj.getAsJsonObject("included"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!LegalPersonsListLegalPersonsResponse.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'LegalPersonsListLegalPersonsResponse' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<LegalPersonsListLegalPersonsResponse> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(LegalPersonsListLegalPersonsResponse.class));

       return (TypeAdapter<T>) new TypeAdapter<LegalPersonsListLegalPersonsResponse>() {
           @Override
           public void write(JsonWriter out, LegalPersonsListLegalPersonsResponse value) throws IOException {
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
           public LegalPersonsListLegalPersonsResponse read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             LegalPersonsListLegalPersonsResponse instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of LegalPersonsListLegalPersonsResponse given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of LegalPersonsListLegalPersonsResponse
  * @throws IOException if the JSON string is invalid with respect to LegalPersonsListLegalPersonsResponse
  */
  public static LegalPersonsListLegalPersonsResponse fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, LegalPersonsListLegalPersonsResponse.class);
  }

 /**
  * Convert an instance of LegalPersonsListLegalPersonsResponse to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

