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
import com.konfigthis.client.model.OpsUserProperty;
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
 * RiskRatingEntry
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class RiskRatingEntry {
  public static final String SERIALIZED_NAME_RISK_RATING_URL = "risk-rating-url";
  @SerializedName(SERIALIZED_NAME_RISK_RATING_URL)
  private String riskRatingUrl;

  /**
   * Gets or Sets riskRating
   */
  @JsonAdapter(RiskRatingEnum.Adapter.class)
 public enum RiskRatingEnum {
    HIGH_RISK("high-risk"),
    
    PROHIBITED_RISK("prohibited-risk"),
    
    MEDIUM_RISK("medium-risk"),
    
    LOW_RISK("low-risk");

    private String value;

    RiskRatingEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static RiskRatingEnum fromValue(String value) {
      for (RiskRatingEnum b : RiskRatingEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<RiskRatingEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final RiskRatingEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public RiskRatingEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return RiskRatingEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_RISK_RATING = "risk-rating";
  @SerializedName(SERIALIZED_NAME_RISK_RATING)
  private RiskRatingEnum riskRating;

  public static final String SERIALIZED_NAME_LEGAL_PERSON_URL = "legal-person-url";
  @SerializedName(SERIALIZED_NAME_LEGAL_PERSON_URL)
  private String legalPersonUrl;

  public static final String SERIALIZED_NAME_NOTES = "notes";
  @SerializedName(SERIALIZED_NAME_NOTES)
  private String notes;

  public static final String SERIALIZED_NAME_MANUALLY_CREATED_BY = "manually-created-by";
  @SerializedName(SERIALIZED_NAME_MANUALLY_CREATED_BY)
  private OpsUserProperty manuallyCreatedBy;

  public static final String SERIALIZED_NAME_VERIFICATION_URL = "verification-url";
  @SerializedName(SERIALIZED_NAME_VERIFICATION_URL)
  private String verificationUrl;

  /**
   * Gets or Sets previousRiskRating
   */
  @JsonAdapter(PreviousRiskRatingEnum.Adapter.class)
 public enum PreviousRiskRatingEnum {
    HIGH_RISK("high-risk"),
    
    PROHIBITED_RISK("prohibited-risk"),
    
    MEDIUM_RISK("medium-risk"),
    
    LOW_RISK("low-risk");

    private String value;

    PreviousRiskRatingEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static PreviousRiskRatingEnum fromValue(String value) {
      for (PreviousRiskRatingEnum b : PreviousRiskRatingEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<PreviousRiskRatingEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final PreviousRiskRatingEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public PreviousRiskRatingEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return PreviousRiskRatingEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_PREVIOUS_RISK_RATING = "previous-risk-rating";
  @SerializedName(SERIALIZED_NAME_PREVIOUS_RISK_RATING)
  private PreviousRiskRatingEnum previousRiskRating;

  public RiskRatingEntry() {
  }

  public RiskRatingEntry riskRatingUrl(String riskRatingUrl) {
    
    
    
    
    this.riskRatingUrl = riskRatingUrl;
    return this;
  }

   /**
   * A contextual link to the risk rating.
   * @return riskRatingUrl
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "/v0/risk-ratings/rr.ICByaXNrLXJhdGluZy1pZA", required = true, value = "A contextual link to the risk rating.")

  public String getRiskRatingUrl() {
    return riskRatingUrl;
  }


  public void setRiskRatingUrl(String riskRatingUrl) {
    
    
    
    this.riskRatingUrl = riskRatingUrl;
  }


  public RiskRatingEntry riskRating(RiskRatingEnum riskRating) {
    
    
    
    
    this.riskRating = riskRating;
    return this;
  }

   /**
   * Get riskRating
   * @return riskRating
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public RiskRatingEnum getRiskRating() {
    return riskRating;
  }


  public void setRiskRating(RiskRatingEnum riskRating) {
    
    
    
    this.riskRating = riskRating;
  }


  public RiskRatingEntry legalPersonUrl(String legalPersonUrl) {
    
    
    
    
    this.legalPersonUrl = legalPersonUrl;
    return this;
  }

   /**
   * A contextual link to the [legal person](http://docs.griffin.com).
   * @return legalPersonUrl
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "/v0/legal-persons/lp.IGxlZ2FsLXBlcnNvbi1pZA", required = true, value = "A contextual link to the [legal person](http://docs.griffin.com).")

  public String getLegalPersonUrl() {
    return legalPersonUrl;
  }


  public void setLegalPersonUrl(String legalPersonUrl) {
    
    
    
    this.legalPersonUrl = legalPersonUrl;
  }


  public RiskRatingEntry notes(String notes) {
    
    
    if (notes != null && notes.length() < 1) {
      throw new IllegalArgumentException("Invalid value for notes. Length must be greater than or equal to 1.");
    }
    
    this.notes = notes;
    return this;
  }

   /**
   * Rationale for overriding the risk rating.
   * @return notes
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Rationale for overriding the risk rating.")

  public String getNotes() {
    return notes;
  }


  public void setNotes(String notes) {
    
    
    if (notes != null && notes.length() < 1) {
      throw new IllegalArgumentException("Invalid value for notes. Length must be greater than or equal to 1.");
    }
    this.notes = notes;
  }


  public RiskRatingEntry manuallyCreatedBy(OpsUserProperty manuallyCreatedBy) {
    
    
    
    
    this.manuallyCreatedBy = manuallyCreatedBy;
    return this;
  }

   /**
   * Get manuallyCreatedBy
   * @return manuallyCreatedBy
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public OpsUserProperty getManuallyCreatedBy() {
    return manuallyCreatedBy;
  }


  public void setManuallyCreatedBy(OpsUserProperty manuallyCreatedBy) {
    
    
    
    this.manuallyCreatedBy = manuallyCreatedBy;
  }


  public RiskRatingEntry verificationUrl(String verificationUrl) {
    
    
    
    
    this.verificationUrl = verificationUrl;
    return this;
  }

   /**
   * A link to the [verification](http://docs.griffin.com).
   * @return verificationUrl
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "/v0/verifications/vn.IHZlcmlmaWNhdGlvbi1pZA", value = "A link to the [verification](http://docs.griffin.com).")

  public String getVerificationUrl() {
    return verificationUrl;
  }


  public void setVerificationUrl(String verificationUrl) {
    
    
    
    this.verificationUrl = verificationUrl;
  }


  public RiskRatingEntry previousRiskRating(PreviousRiskRatingEnum previousRiskRating) {
    
    
    
    
    this.previousRiskRating = previousRiskRating;
    return this;
  }

   /**
   * Get previousRiskRating
   * @return previousRiskRating
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public PreviousRiskRatingEnum getPreviousRiskRating() {
    return previousRiskRating;
  }


  public void setPreviousRiskRating(PreviousRiskRatingEnum previousRiskRating) {
    
    
    
    this.previousRiskRating = previousRiskRating;
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
   * @return the RiskRatingEntry instance itself
   */
  public RiskRatingEntry putAdditionalProperty(String key, Object value) {
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
    RiskRatingEntry riskRatingEntry = (RiskRatingEntry) o;
    return Objects.equals(this.riskRatingUrl, riskRatingEntry.riskRatingUrl) &&
        Objects.equals(this.riskRating, riskRatingEntry.riskRating) &&
        Objects.equals(this.legalPersonUrl, riskRatingEntry.legalPersonUrl) &&
        Objects.equals(this.notes, riskRatingEntry.notes) &&
        Objects.equals(this.manuallyCreatedBy, riskRatingEntry.manuallyCreatedBy) &&
        Objects.equals(this.verificationUrl, riskRatingEntry.verificationUrl) &&
        Objects.equals(this.previousRiskRating, riskRatingEntry.previousRiskRating)&&
        Objects.equals(this.additionalProperties, riskRatingEntry.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(riskRatingUrl, riskRating, legalPersonUrl, notes, manuallyCreatedBy, verificationUrl, previousRiskRating, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RiskRatingEntry {\n");
    sb.append("    riskRatingUrl: ").append(toIndentedString(riskRatingUrl)).append("\n");
    sb.append("    riskRating: ").append(toIndentedString(riskRating)).append("\n");
    sb.append("    legalPersonUrl: ").append(toIndentedString(legalPersonUrl)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    manuallyCreatedBy: ").append(toIndentedString(manuallyCreatedBy)).append("\n");
    sb.append("    verificationUrl: ").append(toIndentedString(verificationUrl)).append("\n");
    sb.append("    previousRiskRating: ").append(toIndentedString(previousRiskRating)).append("\n");
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
    openapiFields.add("risk-rating-url");
    openapiFields.add("risk-rating");
    openapiFields.add("legal-person-url");
    openapiFields.add("notes");
    openapiFields.add("manually-created-by");
    openapiFields.add("verification-url");
    openapiFields.add("previous-risk-rating");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("risk-rating-url");
    openapiRequiredFields.add("risk-rating");
    openapiRequiredFields.add("legal-person-url");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to RiskRatingEntry
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!RiskRatingEntry.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in RiskRatingEntry is not found in the empty JSON string", RiskRatingEntry.openapiRequiredFields.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : RiskRatingEntry.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if (!jsonObj.get("risk-rating-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `risk-rating-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("risk-rating-url").toString()));
      }
      if (!jsonObj.get("risk-rating").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `risk-rating` to be a primitive type in the JSON string but got `%s`", jsonObj.get("risk-rating").toString()));
      }
      if (!jsonObj.get("legal-person-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `legal-person-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("legal-person-url").toString()));
      }
      if ((jsonObj.get("notes") != null && !jsonObj.get("notes").isJsonNull()) && !jsonObj.get("notes").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `notes` to be a primitive type in the JSON string but got `%s`", jsonObj.get("notes").toString()));
      }
      // validate the optional field `manually-created-by`
      if (jsonObj.get("manually-created-by") != null && !jsonObj.get("manually-created-by").isJsonNull()) {
        OpsUserProperty.validateJsonObject(jsonObj.getAsJsonObject("manually-created-by"));
      }
      if ((jsonObj.get("verification-url") != null && !jsonObj.get("verification-url").isJsonNull()) && !jsonObj.get("verification-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `verification-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("verification-url").toString()));
      }
      if ((jsonObj.get("previous-risk-rating") != null && !jsonObj.get("previous-risk-rating").isJsonNull()) && !jsonObj.get("previous-risk-rating").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `previous-risk-rating` to be a primitive type in the JSON string but got `%s`", jsonObj.get("previous-risk-rating").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!RiskRatingEntry.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'RiskRatingEntry' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<RiskRatingEntry> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(RiskRatingEntry.class));

       return (TypeAdapter<T>) new TypeAdapter<RiskRatingEntry>() {
           @Override
           public void write(JsonWriter out, RiskRatingEntry value) throws IOException {
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
           public RiskRatingEntry read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             RiskRatingEntry instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of RiskRatingEntry given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of RiskRatingEntry
  * @throws IOException if the JSON string is invalid with respect to RiskRatingEntry
  */
  public static RiskRatingEntry fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, RiskRatingEntry.class);
  }

 /**
  * Convert an instance of RiskRatingEntry to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

