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
import java.time.OffsetDateTime;

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
 * The most recent [decision](http://docs.griffin.com)
 */
@ApiModel(description = "The most recent [decision](http://docs.griffin.com)")@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class LatestDecisionProperty1 {
  public static final String SERIALIZED_NAME_VERIFICATION_URL = "verification-url";
  @SerializedName(SERIALIZED_NAME_VERIFICATION_URL)
  private String verificationUrl;

  /**
   * Gets or Sets decisionOutcome
   */
  @JsonAdapter(DecisionOutcomeEnum.Adapter.class)
 public enum DecisionOutcomeEnum {
    ACCEPTED("accepted"),
    
    DECLINED("declined");

    private String value;

    DecisionOutcomeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static DecisionOutcomeEnum fromValue(String value) {
      for (DecisionOutcomeEnum b : DecisionOutcomeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<DecisionOutcomeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final DecisionOutcomeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public DecisionOutcomeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return DecisionOutcomeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_DECISION_OUTCOME = "decision-outcome";
  @SerializedName(SERIALIZED_NAME_DECISION_OUTCOME)
  private DecisionOutcomeEnum decisionOutcome;

  /**
   * Indicates if the decision was automated or made by a human.
   */
  @JsonAdapter(DecisionMakerEnum.Adapter.class)
 public enum DecisionMakerEnum {
    SYSTEM("system"),
    
    OPS_USER("ops-user"),
    
    USER("user");

    private String value;

    DecisionMakerEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static DecisionMakerEnum fromValue(String value) {
      for (DecisionMakerEnum b : DecisionMakerEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<DecisionMakerEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final DecisionMakerEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public DecisionMakerEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return DecisionMakerEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_DECISION_MAKER = "decision-maker";
  @SerializedName(SERIALIZED_NAME_DECISION_MAKER)
  private DecisionMakerEnum decisionMaker;

  public static final String SERIALIZED_NAME_DECISION_NOTES = "decision-notes";
  @SerializedName(SERIALIZED_NAME_DECISION_NOTES)
  private String decisionNotes;

  public static final String SERIALIZED_NAME_CREATED_AT = "created-at";
  @SerializedName(SERIALIZED_NAME_CREATED_AT)
  private OffsetDateTime createdAt;

  public static final String SERIALIZED_NAME_DECISION_USER_URL = "decision-user-url";
  @SerializedName(SERIALIZED_NAME_DECISION_USER_URL)
  private String decisionUserUrl;

  public static final String SERIALIZED_NAME_DECISION_USER_USERNAME = "decision-user-username";
  @SerializedName(SERIALIZED_NAME_DECISION_USER_USERNAME)
  private String decisionUserUsername;

  /**
   * Indicates that an Ops user has created the decision.
   */
  @JsonAdapter(DecisionOpsUserEnum.Adapter.class)
 public enum DecisionOpsUserEnum {
    GRIFFIN_OPS_USER("griffin-ops-user");

    private String value;

    DecisionOpsUserEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static DecisionOpsUserEnum fromValue(String value) {
      for (DecisionOpsUserEnum b : DecisionOpsUserEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<DecisionOpsUserEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final DecisionOpsUserEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public DecisionOpsUserEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return DecisionOpsUserEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_DECISION_OPS_USER = "decision-ops-user";
  @SerializedName(SERIALIZED_NAME_DECISION_OPS_USER)
  private DecisionOpsUserEnum decisionOpsUser;

  public LatestDecisionProperty1() {
  }

  public LatestDecisionProperty1 verificationUrl(String verificationUrl) {
    
    
    
    
    this.verificationUrl = verificationUrl;
    return this;
  }

   /**
   * A link to the [verification](http://docs.griffin.com).
   * @return verificationUrl
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "/v0/verifications/vn.IHZlcmlmaWNhdGlvbi1pZA", required = true, value = "A link to the [verification](http://docs.griffin.com).")

  public String getVerificationUrl() {
    return verificationUrl;
  }


  public void setVerificationUrl(String verificationUrl) {
    
    
    
    this.verificationUrl = verificationUrl;
  }


  public LatestDecisionProperty1 decisionOutcome(DecisionOutcomeEnum decisionOutcome) {
    
    
    
    
    this.decisionOutcome = decisionOutcome;
    return this;
  }

   /**
   * Get decisionOutcome
   * @return decisionOutcome
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public DecisionOutcomeEnum getDecisionOutcome() {
    return decisionOutcome;
  }


  public void setDecisionOutcome(DecisionOutcomeEnum decisionOutcome) {
    
    
    
    this.decisionOutcome = decisionOutcome;
  }


  public LatestDecisionProperty1 decisionMaker(DecisionMakerEnum decisionMaker) {
    
    
    
    
    this.decisionMaker = decisionMaker;
    return this;
  }

   /**
   * Indicates if the decision was automated or made by a human.
   * @return decisionMaker
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Indicates if the decision was automated or made by a human.")

  public DecisionMakerEnum getDecisionMaker() {
    return decisionMaker;
  }


  public void setDecisionMaker(DecisionMakerEnum decisionMaker) {
    
    
    
    this.decisionMaker = decisionMaker;
  }


  public LatestDecisionProperty1 decisionNotes(String decisionNotes) {
    
    
    
    
    this.decisionNotes = decisionNotes;
    return this;
  }

   /**
   * Free-text field to explain the reasons behind the decision.
   * @return decisionNotes
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Free-text field to explain the reasons behind the decision.")

  public String getDecisionNotes() {
    return decisionNotes;
  }


  public void setDecisionNotes(String decisionNotes) {
    
    
    
    this.decisionNotes = decisionNotes;
  }


  public LatestDecisionProperty1 createdAt(OffsetDateTime createdAt) {
    
    
    
    
    this.createdAt = createdAt;
    return this;
  }

   /**
   * ISO 8601 formatted date-time.
   * @return createdAt
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "ISO 8601 formatted date-time.")

  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }


  public void setCreatedAt(OffsetDateTime createdAt) {
    
    
    
    this.createdAt = createdAt;
  }


  public LatestDecisionProperty1 decisionUserUrl(String decisionUserUrl) {
    
    
    
    
    this.decisionUserUrl = decisionUserUrl;
    return this;
  }

   /**
   * Link to the [user](http://docs.griffin.com) that made the decision (if applicable).
   * @return decisionUserUrl
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "/v0/users/ur.ICAgICAgICAgdXNlci1pZA", value = "Link to the [user](http://docs.griffin.com) that made the decision (if applicable).")

  public String getDecisionUserUrl() {
    return decisionUserUrl;
  }


  public void setDecisionUserUrl(String decisionUserUrl) {
    
    
    
    this.decisionUserUrl = decisionUserUrl;
  }


  public LatestDecisionProperty1 decisionUserUsername(String decisionUserUsername) {
    
    
    
    
    this.decisionUserUsername = decisionUserUsername;
    return this;
  }

   /**
   * Username of the [user](http://docs.griffin.com) that made the decision (if applicable).
   * @return decisionUserUsername
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "user@example.com", value = "Username of the [user](http://docs.griffin.com) that made the decision (if applicable).")

  public String getDecisionUserUsername() {
    return decisionUserUsername;
  }


  public void setDecisionUserUsername(String decisionUserUsername) {
    
    
    
    this.decisionUserUsername = decisionUserUsername;
  }


  public LatestDecisionProperty1 decisionOpsUser(DecisionOpsUserEnum decisionOpsUser) {
    
    
    
    
    this.decisionOpsUser = decisionOpsUser;
    return this;
  }

   /**
   * Indicates that an Ops user has created the decision.
   * @return decisionOpsUser
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Indicates that an Ops user has created the decision.")

  public DecisionOpsUserEnum getDecisionOpsUser() {
    return decisionOpsUser;
  }


  public void setDecisionOpsUser(DecisionOpsUserEnum decisionOpsUser) {
    
    
    
    this.decisionOpsUser = decisionOpsUser;
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
   * @return the LatestDecisionProperty1 instance itself
   */
  public LatestDecisionProperty1 putAdditionalProperty(String key, Object value) {
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
    LatestDecisionProperty1 latestDecisionProperty1 = (LatestDecisionProperty1) o;
    return Objects.equals(this.verificationUrl, latestDecisionProperty1.verificationUrl) &&
        Objects.equals(this.decisionOutcome, latestDecisionProperty1.decisionOutcome) &&
        Objects.equals(this.decisionMaker, latestDecisionProperty1.decisionMaker) &&
        Objects.equals(this.decisionNotes, latestDecisionProperty1.decisionNotes) &&
        Objects.equals(this.createdAt, latestDecisionProperty1.createdAt) &&
        Objects.equals(this.decisionUserUrl, latestDecisionProperty1.decisionUserUrl) &&
        Objects.equals(this.decisionUserUsername, latestDecisionProperty1.decisionUserUsername) &&
        Objects.equals(this.decisionOpsUser, latestDecisionProperty1.decisionOpsUser)&&
        Objects.equals(this.additionalProperties, latestDecisionProperty1.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(verificationUrl, decisionOutcome, decisionMaker, decisionNotes, createdAt, decisionUserUrl, decisionUserUsername, decisionOpsUser, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LatestDecisionProperty1 {\n");
    sb.append("    verificationUrl: ").append(toIndentedString(verificationUrl)).append("\n");
    sb.append("    decisionOutcome: ").append(toIndentedString(decisionOutcome)).append("\n");
    sb.append("    decisionMaker: ").append(toIndentedString(decisionMaker)).append("\n");
    sb.append("    decisionNotes: ").append(toIndentedString(decisionNotes)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    decisionUserUrl: ").append(toIndentedString(decisionUserUrl)).append("\n");
    sb.append("    decisionUserUsername: ").append(toIndentedString(decisionUserUsername)).append("\n");
    sb.append("    decisionOpsUser: ").append(toIndentedString(decisionOpsUser)).append("\n");
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
    openapiFields.add("verification-url");
    openapiFields.add("decision-outcome");
    openapiFields.add("decision-maker");
    openapiFields.add("decision-notes");
    openapiFields.add("created-at");
    openapiFields.add("decision-user-url");
    openapiFields.add("decision-user-username");
    openapiFields.add("decision-ops-user");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("verification-url");
    openapiRequiredFields.add("decision-outcome");
    openapiRequiredFields.add("decision-maker");
    openapiRequiredFields.add("decision-notes");
    openapiRequiredFields.add("created-at");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to LatestDecisionProperty1
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!LatestDecisionProperty1.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in LatestDecisionProperty1 is not found in the empty JSON string", LatestDecisionProperty1.openapiRequiredFields.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : LatestDecisionProperty1.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if (!jsonObj.get("verification-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `verification-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("verification-url").toString()));
      }
      if (!jsonObj.get("decision-outcome").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `decision-outcome` to be a primitive type in the JSON string but got `%s`", jsonObj.get("decision-outcome").toString()));
      }
      if (!jsonObj.get("decision-maker").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `decision-maker` to be a primitive type in the JSON string but got `%s`", jsonObj.get("decision-maker").toString()));
      }
      if (!jsonObj.get("decision-notes").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `decision-notes` to be a primitive type in the JSON string but got `%s`", jsonObj.get("decision-notes").toString()));
      }
      if ((jsonObj.get("decision-user-url") != null && !jsonObj.get("decision-user-url").isJsonNull()) && !jsonObj.get("decision-user-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `decision-user-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("decision-user-url").toString()));
      }
      if ((jsonObj.get("decision-user-username") != null && !jsonObj.get("decision-user-username").isJsonNull()) && !jsonObj.get("decision-user-username").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `decision-user-username` to be a primitive type in the JSON string but got `%s`", jsonObj.get("decision-user-username").toString()));
      }
      if ((jsonObj.get("decision-ops-user") != null && !jsonObj.get("decision-ops-user").isJsonNull()) && !jsonObj.get("decision-ops-user").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `decision-ops-user` to be a primitive type in the JSON string but got `%s`", jsonObj.get("decision-ops-user").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!LatestDecisionProperty1.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'LatestDecisionProperty1' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<LatestDecisionProperty1> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(LatestDecisionProperty1.class));

       return (TypeAdapter<T>) new TypeAdapter<LatestDecisionProperty1>() {
           @Override
           public void write(JsonWriter out, LatestDecisionProperty1 value) throws IOException {
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
           public LatestDecisionProperty1 read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             LatestDecisionProperty1 instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of LatestDecisionProperty1 given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of LatestDecisionProperty1
  * @throws IOException if the JSON string is invalid with respect to LatestDecisionProperty1
  */
  public static LatestDecisionProperty1 fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, LatestDecisionProperty1.class);
  }

 /**
  * Convert an instance of LatestDecisionProperty1 to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

