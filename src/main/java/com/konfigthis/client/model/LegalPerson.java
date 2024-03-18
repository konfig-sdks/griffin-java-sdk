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
import com.konfigthis.client.model.LatestDecisionProperty;
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
 * LegalPerson
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class LegalPerson {
  public static final String SERIALIZED_NAME_LATEST_DECISION = "latest-decision";
  @SerializedName(SERIALIZED_NAME_LATEST_DECISION)
  private LatestDecisionProperty latestDecision;

  /**
   * Specifies if the legal person is an &#x60;individual&#x60; or a &#x60;corporation&#x60;.
   */
  @JsonAdapter(LegalPersonTypeEnum.Adapter.class)
 public enum LegalPersonTypeEnum {
    INDIVIDUAL("individual"),
    
    CORPORATION("corporation");

    private String value;

    LegalPersonTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static LegalPersonTypeEnum fromValue(String value) {
      for (LegalPersonTypeEnum b : LegalPersonTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<LegalPersonTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final LegalPersonTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public LegalPersonTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return LegalPersonTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_LEGAL_PERSON_TYPE = "legal-person-type";
  @SerializedName(SERIALIZED_NAME_LEGAL_PERSON_TYPE)
  private LegalPersonTypeEnum legalPersonType;

  public static final String SERIALIZED_NAME_LATEST_RISK_RATING_URL = "latest-risk-rating-url";
  @SerializedName(SERIALIZED_NAME_LATEST_RISK_RATING_URL)
  private String latestRiskRatingUrl;

  public static final String SERIALIZED_NAME_DISPLAY_NAME = "display-name";
  @SerializedName(SERIALIZED_NAME_DISPLAY_NAME)
  private String displayName;

  /**
   * Status of the current [application](http://docs.griffin.com)
   */
  @JsonAdapter(ApplicationStatusEnum.Adapter.class)
 public enum ApplicationStatusEnum {
    REFERRED("referred"),
    
    ERRORED("errored"),
    
    DECLINED("declined"),
    
    SUBMITTED("submitted"),
    
    ACCEPTED("accepted");

    private String value;

    ApplicationStatusEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ApplicationStatusEnum fromValue(String value) {
      for (ApplicationStatusEnum b : ApplicationStatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ApplicationStatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ApplicationStatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ApplicationStatusEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ApplicationStatusEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_APPLICATION_STATUS = "application-status";
  @SerializedName(SERIALIZED_NAME_APPLICATION_STATUS)
  private ApplicationStatusEnum applicationStatus;

  public static final String SERIALIZED_NAME_LEGAL_PERSON_URL = "legal-person-url";
  @SerializedName(SERIALIZED_NAME_LEGAL_PERSON_URL)
  private String legalPersonUrl;

  public static final String SERIALIZED_NAME_LEGAL_PERSON_DECISIONS_URL = "legal-person-decisions-url";
  @SerializedName(SERIALIZED_NAME_LEGAL_PERSON_DECISIONS_URL)
  private String legalPersonDecisionsUrl;

  public static final String SERIALIZED_NAME_STATUS_CHANGED_AT = "status-changed-at";
  @SerializedName(SERIALIZED_NAME_STATUS_CHANGED_AT)
  private OffsetDateTime statusChangedAt;

  public static final String SERIALIZED_NAME_CREATED_AT = "created-at";
  @SerializedName(SERIALIZED_NAME_CREATED_AT)
  private OffsetDateTime createdAt;

  public static final String SERIALIZED_NAME_LEGAL_PERSON_CLAIMS_URL = "legal-person-claims-url";
  @SerializedName(SERIALIZED_NAME_LEGAL_PERSON_CLAIMS_URL)
  private String legalPersonClaimsUrl;

  public static final String SERIALIZED_NAME_LEGAL_PERSON_BANK_PAYEES_URL = "legal-person-bank-payees-url";
  @SerializedName(SERIALIZED_NAME_LEGAL_PERSON_BANK_PAYEES_URL)
  private String legalPersonBankPayeesUrl;

  public static final String SERIALIZED_NAME_LEGAL_PERSON_VERIFICATIONS_URL = "legal-person-verifications-url";
  @SerializedName(SERIALIZED_NAME_LEGAL_PERSON_VERIFICATIONS_URL)
  private String legalPersonVerificationsUrl;

  public static final String SERIALIZED_NAME_LEGAL_PERSON_DOCUMENTS_URL = "legal-person-documents-url";
  @SerializedName(SERIALIZED_NAME_LEGAL_PERSON_DOCUMENTS_URL)
  private String legalPersonDocumentsUrl;

  public LegalPerson() {
  }

  public LegalPerson latestDecision(LatestDecisionProperty latestDecision) {
    
    
    
    
    this.latestDecision = latestDecision;
    return this;
  }

   /**
   * Get latestDecision
   * @return latestDecision
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public LatestDecisionProperty getLatestDecision() {
    return latestDecision;
  }


  public void setLatestDecision(LatestDecisionProperty latestDecision) {
    
    
    
    this.latestDecision = latestDecision;
  }


  public LegalPerson legalPersonType(LegalPersonTypeEnum legalPersonType) {
    
    
    
    
    this.legalPersonType = legalPersonType;
    return this;
  }

   /**
   * Specifies if the legal person is an &#x60;individual&#x60; or a &#x60;corporation&#x60;.
   * @return legalPersonType
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Specifies if the legal person is an `individual` or a `corporation`.")

  public LegalPersonTypeEnum getLegalPersonType() {
    return legalPersonType;
  }


  public void setLegalPersonType(LegalPersonTypeEnum legalPersonType) {
    
    
    
    this.legalPersonType = legalPersonType;
  }


  public LegalPerson latestRiskRatingUrl(String latestRiskRatingUrl) {
    
    
    
    
    this.latestRiskRatingUrl = latestRiskRatingUrl;
    return this;
  }

   /**
   * A contextual link to the risk rating.
   * @return latestRiskRatingUrl
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "/v0/risk-ratings/rr.ICByaXNrLXJhdGluZy1pZA", value = "A contextual link to the risk rating.")

  public String getLatestRiskRatingUrl() {
    return latestRiskRatingUrl;
  }


  public void setLatestRiskRatingUrl(String latestRiskRatingUrl) {
    
    
    
    this.latestRiskRatingUrl = latestRiskRatingUrl;
  }


  public LegalPerson displayName(String displayName) {
    
    
    if (displayName != null && displayName.length() < 1) {
      throw new IllegalArgumentException("Invalid value for displayName. Length must be greater than or equal to 1.");
    }
    
    this.displayName = displayName;
    return this;
  }

   /**
   * A human readable label for an entity
   * @return displayName
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "A human readable label for an entity")

  public String getDisplayName() {
    return displayName;
  }


  public void setDisplayName(String displayName) {
    
    
    if (displayName != null && displayName.length() < 1) {
      throw new IllegalArgumentException("Invalid value for displayName. Length must be greater than or equal to 1.");
    }
    this.displayName = displayName;
  }


  public LegalPerson applicationStatus(ApplicationStatusEnum applicationStatus) {
    
    
    
    
    this.applicationStatus = applicationStatus;
    return this;
  }

   /**
   * Status of the current [application](http://docs.griffin.com)
   * @return applicationStatus
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Status of the current [application](http://docs.griffin.com)")

  public ApplicationStatusEnum getApplicationStatus() {
    return applicationStatus;
  }


  public void setApplicationStatus(ApplicationStatusEnum applicationStatus) {
    
    
    
    this.applicationStatus = applicationStatus;
  }


  public LegalPerson legalPersonUrl(String legalPersonUrl) {
    
    
    
    
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


  public LegalPerson legalPersonDecisionsUrl(String legalPersonDecisionsUrl) {
    
    
    
    
    this.legalPersonDecisionsUrl = legalPersonDecisionsUrl;
    return this;
  }

   /**
   * Link to [decisions](http://docs.griffin.com) for this [legal person](http://docs.griffin.com).
   * @return legalPersonDecisionsUrl
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "/v0/legal-persons/lp.IGxlZ2FsLXBlcnNvbi1pZA/decisions", required = true, value = "Link to [decisions](http://docs.griffin.com) for this [legal person](http://docs.griffin.com).")

  public String getLegalPersonDecisionsUrl() {
    return legalPersonDecisionsUrl;
  }


  public void setLegalPersonDecisionsUrl(String legalPersonDecisionsUrl) {
    
    
    
    this.legalPersonDecisionsUrl = legalPersonDecisionsUrl;
  }


  public LegalPerson statusChangedAt(OffsetDateTime statusChangedAt) {
    
    
    
    
    this.statusChangedAt = statusChangedAt;
    return this;
  }

   /**
   * ISO 8601 formatted date-time.
   * @return statusChangedAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "ISO 8601 formatted date-time.")

  public OffsetDateTime getStatusChangedAt() {
    return statusChangedAt;
  }


  public void setStatusChangedAt(OffsetDateTime statusChangedAt) {
    
    
    
    this.statusChangedAt = statusChangedAt;
  }


  public LegalPerson createdAt(OffsetDateTime createdAt) {
    
    
    
    
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


  public LegalPerson legalPersonClaimsUrl(String legalPersonClaimsUrl) {
    
    
    
    
    this.legalPersonClaimsUrl = legalPersonClaimsUrl;
    return this;
  }

   /**
   * Link to the [claims](http://docs.griffin.com) for this [legal person](http://docs.griffin.com).
   * @return legalPersonClaimsUrl
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "/v0/legal-persons/lp.IGxlZ2FsLXBlcnNvbi1pZA/claims", value = "Link to the [claims](http://docs.griffin.com) for this [legal person](http://docs.griffin.com).")

  public String getLegalPersonClaimsUrl() {
    return legalPersonClaimsUrl;
  }


  public void setLegalPersonClaimsUrl(String legalPersonClaimsUrl) {
    
    
    
    this.legalPersonClaimsUrl = legalPersonClaimsUrl;
  }


  public LegalPerson legalPersonBankPayeesUrl(String legalPersonBankPayeesUrl) {
    
    
    
    
    this.legalPersonBankPayeesUrl = legalPersonBankPayeesUrl;
    return this;
  }

   /**
   * Link to the [payees](http://docs.griffin.com) for this [legal person](http://docs.griffin.com).
   * @return legalPersonBankPayeesUrl
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "/v0/legal-persons/lp.IGxlZ2FsLXBlcnNvbi1pZA/bank/payees", value = "Link to the [payees](http://docs.griffin.com) for this [legal person](http://docs.griffin.com).")

  public String getLegalPersonBankPayeesUrl() {
    return legalPersonBankPayeesUrl;
  }


  public void setLegalPersonBankPayeesUrl(String legalPersonBankPayeesUrl) {
    
    
    
    this.legalPersonBankPayeesUrl = legalPersonBankPayeesUrl;
  }


  public LegalPerson legalPersonVerificationsUrl(String legalPersonVerificationsUrl) {
    
    
    
    
    this.legalPersonVerificationsUrl = legalPersonVerificationsUrl;
    return this;
  }

   /**
   * Link to all [verifications](http://docs.griffin.com) run against this [legal person](http://docs.griffin.com).
   * @return legalPersonVerificationsUrl
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "/v0/legal-persons/lp.IGxlZ2FsLXBlcnNvbi1pZA/verifications", required = true, value = "Link to all [verifications](http://docs.griffin.com) run against this [legal person](http://docs.griffin.com).")

  public String getLegalPersonVerificationsUrl() {
    return legalPersonVerificationsUrl;
  }


  public void setLegalPersonVerificationsUrl(String legalPersonVerificationsUrl) {
    
    
    
    this.legalPersonVerificationsUrl = legalPersonVerificationsUrl;
  }


  public LegalPerson legalPersonDocumentsUrl(String legalPersonDocumentsUrl) {
    
    
    
    
    this.legalPersonDocumentsUrl = legalPersonDocumentsUrl;
    return this;
  }

   /**
   * Link to all evidence documents associated with this [legal person](http://docs.griffin.com).
   * @return legalPersonDocumentsUrl
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "/v0/legal-persons/lp.IGxlZ2FsLXBlcnNvbi1pZA/documents", required = true, value = "Link to all evidence documents associated with this [legal person](http://docs.griffin.com).")

  public String getLegalPersonDocumentsUrl() {
    return legalPersonDocumentsUrl;
  }


  public void setLegalPersonDocumentsUrl(String legalPersonDocumentsUrl) {
    
    
    
    this.legalPersonDocumentsUrl = legalPersonDocumentsUrl;
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
   * @return the LegalPerson instance itself
   */
  public LegalPerson putAdditionalProperty(String key, Object value) {
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
    LegalPerson legalPerson = (LegalPerson) o;
    return Objects.equals(this.latestDecision, legalPerson.latestDecision) &&
        Objects.equals(this.legalPersonType, legalPerson.legalPersonType) &&
        Objects.equals(this.latestRiskRatingUrl, legalPerson.latestRiskRatingUrl) &&
        Objects.equals(this.displayName, legalPerson.displayName) &&
        Objects.equals(this.applicationStatus, legalPerson.applicationStatus) &&
        Objects.equals(this.legalPersonUrl, legalPerson.legalPersonUrl) &&
        Objects.equals(this.legalPersonDecisionsUrl, legalPerson.legalPersonDecisionsUrl) &&
        Objects.equals(this.statusChangedAt, legalPerson.statusChangedAt) &&
        Objects.equals(this.createdAt, legalPerson.createdAt) &&
        Objects.equals(this.legalPersonClaimsUrl, legalPerson.legalPersonClaimsUrl) &&
        Objects.equals(this.legalPersonBankPayeesUrl, legalPerson.legalPersonBankPayeesUrl) &&
        Objects.equals(this.legalPersonVerificationsUrl, legalPerson.legalPersonVerificationsUrl) &&
        Objects.equals(this.legalPersonDocumentsUrl, legalPerson.legalPersonDocumentsUrl)&&
        Objects.equals(this.additionalProperties, legalPerson.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(latestDecision, legalPersonType, latestRiskRatingUrl, displayName, applicationStatus, legalPersonUrl, legalPersonDecisionsUrl, statusChangedAt, createdAt, legalPersonClaimsUrl, legalPersonBankPayeesUrl, legalPersonVerificationsUrl, legalPersonDocumentsUrl, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LegalPerson {\n");
    sb.append("    latestDecision: ").append(toIndentedString(latestDecision)).append("\n");
    sb.append("    legalPersonType: ").append(toIndentedString(legalPersonType)).append("\n");
    sb.append("    latestRiskRatingUrl: ").append(toIndentedString(latestRiskRatingUrl)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    applicationStatus: ").append(toIndentedString(applicationStatus)).append("\n");
    sb.append("    legalPersonUrl: ").append(toIndentedString(legalPersonUrl)).append("\n");
    sb.append("    legalPersonDecisionsUrl: ").append(toIndentedString(legalPersonDecisionsUrl)).append("\n");
    sb.append("    statusChangedAt: ").append(toIndentedString(statusChangedAt)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    legalPersonClaimsUrl: ").append(toIndentedString(legalPersonClaimsUrl)).append("\n");
    sb.append("    legalPersonBankPayeesUrl: ").append(toIndentedString(legalPersonBankPayeesUrl)).append("\n");
    sb.append("    legalPersonVerificationsUrl: ").append(toIndentedString(legalPersonVerificationsUrl)).append("\n");
    sb.append("    legalPersonDocumentsUrl: ").append(toIndentedString(legalPersonDocumentsUrl)).append("\n");
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
    openapiFields.add("latest-decision");
    openapiFields.add("legal-person-type");
    openapiFields.add("latest-risk-rating-url");
    openapiFields.add("display-name");
    openapiFields.add("application-status");
    openapiFields.add("legal-person-url");
    openapiFields.add("legal-person-decisions-url");
    openapiFields.add("status-changed-at");
    openapiFields.add("created-at");
    openapiFields.add("legal-person-claims-url");
    openapiFields.add("legal-person-bank-payees-url");
    openapiFields.add("legal-person-verifications-url");
    openapiFields.add("legal-person-documents-url");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("legal-person-type");
    openapiRequiredFields.add("display-name");
    openapiRequiredFields.add("legal-person-url");
    openapiRequiredFields.add("legal-person-decisions-url");
    openapiRequiredFields.add("created-at");
    openapiRequiredFields.add("legal-person-verifications-url");
    openapiRequiredFields.add("legal-person-documents-url");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to LegalPerson
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!LegalPerson.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in LegalPerson is not found in the empty JSON string", LegalPerson.openapiRequiredFields.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : LegalPerson.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      // validate the optional field `latest-decision`
      if (jsonObj.get("latest-decision") != null && !jsonObj.get("latest-decision").isJsonNull()) {
        LatestDecisionProperty.validateJsonObject(jsonObj.getAsJsonObject("latest-decision"));
      }
      if (!jsonObj.get("legal-person-type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `legal-person-type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("legal-person-type").toString()));
      }
      if ((jsonObj.get("latest-risk-rating-url") != null && !jsonObj.get("latest-risk-rating-url").isJsonNull()) && !jsonObj.get("latest-risk-rating-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `latest-risk-rating-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("latest-risk-rating-url").toString()));
      }
      if (!jsonObj.get("display-name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `display-name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("display-name").toString()));
      }
      if ((jsonObj.get("application-status") != null && !jsonObj.get("application-status").isJsonNull()) && !jsonObj.get("application-status").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `application-status` to be a primitive type in the JSON string but got `%s`", jsonObj.get("application-status").toString()));
      }
      if (!jsonObj.get("legal-person-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `legal-person-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("legal-person-url").toString()));
      }
      if (!jsonObj.get("legal-person-decisions-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `legal-person-decisions-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("legal-person-decisions-url").toString()));
      }
      if ((jsonObj.get("legal-person-claims-url") != null && !jsonObj.get("legal-person-claims-url").isJsonNull()) && !jsonObj.get("legal-person-claims-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `legal-person-claims-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("legal-person-claims-url").toString()));
      }
      if ((jsonObj.get("legal-person-bank-payees-url") != null && !jsonObj.get("legal-person-bank-payees-url").isJsonNull()) && !jsonObj.get("legal-person-bank-payees-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `legal-person-bank-payees-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("legal-person-bank-payees-url").toString()));
      }
      if (!jsonObj.get("legal-person-verifications-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `legal-person-verifications-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("legal-person-verifications-url").toString()));
      }
      if (!jsonObj.get("legal-person-documents-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `legal-person-documents-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("legal-person-documents-url").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!LegalPerson.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'LegalPerson' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<LegalPerson> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(LegalPerson.class));

       return (TypeAdapter<T>) new TypeAdapter<LegalPerson>() {
           @Override
           public void write(JsonWriter out, LegalPerson value) throws IOException {
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
           public LegalPerson read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             LegalPerson instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of LegalPerson given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of LegalPerson
  * @throws IOException if the JSON string is invalid with respect to LegalPerson
  */
  public static LegalPerson fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, LegalPerson.class);
  }

 /**
  * Convert an instance of LegalPerson to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

