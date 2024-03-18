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
import com.konfigthis.client.model.CompanyAddressProperty;
import com.konfigthis.client.model.Director;
import com.konfigthis.client.model.PersonWithSignificantControl;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.time.LocalDate;
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
 * CompaniesHouseGetCompanyDetailsResponse
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class CompaniesHouseGetCompanyDetailsResponse {
  public static final String SERIALIZED_NAME_COMPANY_ADDRESS = "company-address";
  @SerializedName(SERIALIZED_NAME_COMPANY_ADDRESS)
  private CompanyAddressProperty companyAddress;

  public static final String SERIALIZED_NAME_DATE_OF_LATEST_ACCOUNTS = "date-of-latest-accounts";
  @SerializedName(SERIALIZED_NAME_DATE_OF_LATEST_ACCOUNTS)
  private LocalDate dateOfLatestAccounts;

  public static final String SERIALIZED_NAME_ENTITY_NAME = "entity-name";
  @SerializedName(SERIALIZED_NAME_ENTITY_NAME)
  private String entityName;

  public static final String SERIALIZED_NAME_DIRECTORS = "directors";
  @SerializedName(SERIALIZED_NAME_DIRECTORS)
  private List<Director> directors = new ArrayList<>();

  public static final String SERIALIZED_NAME_DATE_OF_LATEST_CONFIRMATION_STATEMENT = "date-of-latest-confirmation-statement";
  @SerializedName(SERIALIZED_NAME_DATE_OF_LATEST_CONFIRMATION_STATEMENT)
  private LocalDate dateOfLatestConfirmationStatement;

  /**
   * Gets or Sets corporationType
   */
  @JsonAdapter(CorporationTypeEnum.Adapter.class)
 public enum CorporationTypeEnum {
    PRIVATE_LIMITED_GUARANT_NSC_LIMITED_EXEMPTION("private-limited-guarant-nsc-limited-exemption"),
    
    EEIG("eeig"),
    
    PRIVATE_LIMITED_SHARES_SECTION_30_EXEMPTION("private-limited-shares-section-30-exemption"),
    
    LIMITED_PARTNERSHIP("limited-partnership"),
    
    ROYAL_CHARTER("royal-charter"),
    
    PRIVATE_UNLIMITED_NSC("private-unlimited-nsc"),
    
    OLD_PUBLIC_COMPANY("old-public-company"),
    
    INVESTMENT_COMPANY_WITH_VARIABLE_CAPITAL("investment-company-with-variable-capital"),
    
    OTHER_COMPANY_TYPE("other-company-type"),
    
    CONVERTED_OR_CLOSED("converted-or-closed"),
    
    PROTECTED_CELL_COMPANY("protected-cell-company"),
    
    PRIVATE_LIMITED_GUARANT_NSC("private-limited-guarant-nsc"),
    
    SCOTTISH_CHARITABLE_INCORPORATED_ORGANISATION("scottish-charitable-incorporated-organisation"),
    
    INDUSTRIAL_AND_PROVIDENT_SOCIETY("industrial-and-provident-society"),
    
    REGISTERED_SOCIETY_NON_JURISDICTIONAL("registered-society-non-jurisdictional"),
    
    PRIVATE_UNLIMITED("private-unlimited"),
    
    FURTHER_EDUCATION_OR_SIXTH_FORM_COLLEGE_CORPORATION("further-education-or-sixth-form-college-corporation"),
    
    LIMITED_LIABILITY_PARTNERSHIP("limited-liability-partnership"),
    
    ASSURANCE_COMPANY("assurance-company"),
    
    OTHER("other"),
    
    NORTHERN_IRELAND_OTHER("northern-ireland-other"),
    
    CHARITABLE_INCORPORATED_ORGANISATION("charitable-incorporated-organisation"),
    
    OVERSEA_COMPANY("oversea-company"),
    
    ICVC_SECURITIES("icvc-securities"),
    
    UK_ESTABLISHMENT("uk-establishment"),
    
    UNREGISTERED_COMPANY("unregistered-company"),
    
    ICVC_WARRANT("icvc-warrant"),
    
    REGISTERED_OVERSEAS_ENTITY("registered-overseas-entity"),
    
    PUBLIC_LIMITED_COMPANY("public-limited-company"),
    
    PRIVATE_LIMITED_COMPANY("private-limited-company"),
    
    EUROPEAN_PUBLIC_LIMITED_LIABILITY_COMPANY_SE("european-public-limited-liability-company-se"),
    
    PRIVATE_UNLIMTED_NSC("private-unlimted-nsc"),
    
    NORTHERN_IRELAND("northern-ireland"),
    
    ICVC_UMBRELLA("icvc-umbrella"),
    
    SCOTTISH_PARTNERSHIP("scottish-partnership");

    private String value;

    CorporationTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static CorporationTypeEnum fromValue(String value) {
      for (CorporationTypeEnum b : CorporationTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<CorporationTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final CorporationTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public CorporationTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return CorporationTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_CORPORATION_TYPE = "corporation-type";
  @SerializedName(SERIALIZED_NAME_CORPORATION_TYPE)
  private CorporationTypeEnum corporationType;

  /**
   * Gets or Sets companyStatus
   */
  @JsonAdapter(CompanyStatusEnum.Adapter.class)
 public enum CompanyStatusEnum {
    DISSOLVED("dissolved"),
    
    ACTIVE("active"),
    
    RECEIVERSHIP("receivership"),
    
    REGISTERED("registered"),
    
    REMOVED("removed"),
    
    ADMINISTRATION("administration"),
    
    OPEN("open"),
    
    CLOSED("closed"),
    
    VOLUNTARY_ARRANGEMENT("voluntary-arrangement"),
    
    LIQUIDATION("liquidation"),
    
    CONVERTED_CLOSED("converted-closed"),
    
    INSOLVENCY_PROCEEDINGS("insolvency-proceedings");

    private String value;

    CompanyStatusEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static CompanyStatusEnum fromValue(String value) {
      for (CompanyStatusEnum b : CompanyStatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<CompanyStatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final CompanyStatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public CompanyStatusEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return CompanyStatusEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_COMPANY_STATUS = "company-status";
  @SerializedName(SERIALIZED_NAME_COMPANY_STATUS)
  private CompanyStatusEnum companyStatus;

  public static final String SERIALIZED_NAME_ACCOUNTS_OVERDUE = "accounts-overdue";
  @SerializedName(SERIALIZED_NAME_ACCOUNTS_OVERDUE)
  private Boolean accountsOverdue;

  public static final String SERIALIZED_NAME_SIC_CODES = "sic-codes";
  @SerializedName(SERIALIZED_NAME_SIC_CODES)
  private List<String> sicCodes = null;

  public static final String SERIALIZED_NAME_PERSONS_WITH_SIGNIFICANT_CONTROL = "persons-with-significant-control";
  @SerializedName(SERIALIZED_NAME_PERSONS_WITH_SIGNIFICANT_CONTROL)
  private List<PersonWithSignificantControl> personsWithSignificantControl = new ArrayList<>();

  public static final String SERIALIZED_NAME_CONFIRMATION_STATEMENT_OVERDUE = "confirmation-statement-overdue";
  @SerializedName(SERIALIZED_NAME_CONFIRMATION_STATEMENT_OVERDUE)
  private Boolean confirmationStatementOverdue;

  public static final String SERIALIZED_NAME_DATE_OF_INCORPORATION = "date-of-incorporation";
  @SerializedName(SERIALIZED_NAME_DATE_OF_INCORPORATION)
  private LocalDate dateOfIncorporation;

  public static final String SERIALIZED_NAME_ENTITY_REGISTRATION_NUMBER = "entity-registration-number";
  @SerializedName(SERIALIZED_NAME_ENTITY_REGISTRATION_NUMBER)
  private String entityRegistrationNumber;

  public CompaniesHouseGetCompanyDetailsResponse() {
  }

  public CompaniesHouseGetCompanyDetailsResponse companyAddress(CompanyAddressProperty companyAddress) {
    
    
    
    
    this.companyAddress = companyAddress;
    return this;
  }

   /**
   * Get companyAddress
   * @return companyAddress
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public CompanyAddressProperty getCompanyAddress() {
    return companyAddress;
  }


  public void setCompanyAddress(CompanyAddressProperty companyAddress) {
    
    
    
    this.companyAddress = companyAddress;
  }


  public CompaniesHouseGetCompanyDetailsResponse dateOfLatestAccounts(LocalDate dateOfLatestAccounts) {
    
    
    
    
    this.dateOfLatestAccounts = dateOfLatestAccounts;
    return this;
  }

   /**
   * ISO 8601 formatted date.
   * @return dateOfLatestAccounts
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "ISO 8601 formatted date.")

  public LocalDate getDateOfLatestAccounts() {
    return dateOfLatestAccounts;
  }


  public void setDateOfLatestAccounts(LocalDate dateOfLatestAccounts) {
    
    
    
    this.dateOfLatestAccounts = dateOfLatestAccounts;
  }


  public CompaniesHouseGetCompanyDetailsResponse entityName(String entityName) {
    
    
    
    
    this.entityName = entityName;
    return this;
  }

   /**
   * Get entityName
   * @return entityName
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public String getEntityName() {
    return entityName;
  }


  public void setEntityName(String entityName) {
    
    
    
    this.entityName = entityName;
  }


  public CompaniesHouseGetCompanyDetailsResponse directors(List<Director> directors) {
    
    
    
    
    this.directors = directors;
    return this;
  }

  public CompaniesHouseGetCompanyDetailsResponse addDirectorsItem(Director directorsItem) {
    this.directors.add(directorsItem);
    return this;
  }

   /**
   * Get directors
   * @return directors
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public List<Director> getDirectors() {
    return directors;
  }


  public void setDirectors(List<Director> directors) {
    
    
    
    this.directors = directors;
  }


  public CompaniesHouseGetCompanyDetailsResponse dateOfLatestConfirmationStatement(LocalDate dateOfLatestConfirmationStatement) {
    
    
    
    
    this.dateOfLatestConfirmationStatement = dateOfLatestConfirmationStatement;
    return this;
  }

   /**
   * ISO 8601 formatted date.
   * @return dateOfLatestConfirmationStatement
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "ISO 8601 formatted date.")

  public LocalDate getDateOfLatestConfirmationStatement() {
    return dateOfLatestConfirmationStatement;
  }


  public void setDateOfLatestConfirmationStatement(LocalDate dateOfLatestConfirmationStatement) {
    
    
    
    this.dateOfLatestConfirmationStatement = dateOfLatestConfirmationStatement;
  }


  public CompaniesHouseGetCompanyDetailsResponse corporationType(CorporationTypeEnum corporationType) {
    
    
    
    
    this.corporationType = corporationType;
    return this;
  }

   /**
   * Get corporationType
   * @return corporationType
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public CorporationTypeEnum getCorporationType() {
    return corporationType;
  }


  public void setCorporationType(CorporationTypeEnum corporationType) {
    
    
    
    this.corporationType = corporationType;
  }


  public CompaniesHouseGetCompanyDetailsResponse companyStatus(CompanyStatusEnum companyStatus) {
    
    
    
    
    this.companyStatus = companyStatus;
    return this;
  }

   /**
   * Get companyStatus
   * @return companyStatus
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public CompanyStatusEnum getCompanyStatus() {
    return companyStatus;
  }


  public void setCompanyStatus(CompanyStatusEnum companyStatus) {
    
    
    
    this.companyStatus = companyStatus;
  }


  public CompaniesHouseGetCompanyDetailsResponse accountsOverdue(Boolean accountsOverdue) {
    
    
    
    
    this.accountsOverdue = accountsOverdue;
    return this;
  }

   /**
   * Get accountsOverdue
   * @return accountsOverdue
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getAccountsOverdue() {
    return accountsOverdue;
  }


  public void setAccountsOverdue(Boolean accountsOverdue) {
    
    
    
    this.accountsOverdue = accountsOverdue;
  }


  public CompaniesHouseGetCompanyDetailsResponse sicCodes(List<String> sicCodes) {
    
    
    
    
    this.sicCodes = sicCodes;
    return this;
  }

  public CompaniesHouseGetCompanyDetailsResponse addSicCodesItem(String sicCodesItem) {
    if (this.sicCodes == null) {
      this.sicCodes = new ArrayList<>();
    }
    this.sicCodes.add(sicCodesItem);
    return this;
  }

   /**
   * Get sicCodes
   * @return sicCodes
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<String> getSicCodes() {
    return sicCodes;
  }


  public void setSicCodes(List<String> sicCodes) {
    
    
    
    this.sicCodes = sicCodes;
  }


  public CompaniesHouseGetCompanyDetailsResponse personsWithSignificantControl(List<PersonWithSignificantControl> personsWithSignificantControl) {
    
    
    
    
    this.personsWithSignificantControl = personsWithSignificantControl;
    return this;
  }

  public CompaniesHouseGetCompanyDetailsResponse addPersonsWithSignificantControlItem(PersonWithSignificantControl personsWithSignificantControlItem) {
    this.personsWithSignificantControl.add(personsWithSignificantControlItem);
    return this;
  }

   /**
   * Get personsWithSignificantControl
   * @return personsWithSignificantControl
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public List<PersonWithSignificantControl> getPersonsWithSignificantControl() {
    return personsWithSignificantControl;
  }


  public void setPersonsWithSignificantControl(List<PersonWithSignificantControl> personsWithSignificantControl) {
    
    
    
    this.personsWithSignificantControl = personsWithSignificantControl;
  }


  public CompaniesHouseGetCompanyDetailsResponse confirmationStatementOverdue(Boolean confirmationStatementOverdue) {
    
    
    
    
    this.confirmationStatementOverdue = confirmationStatementOverdue;
    return this;
  }

   /**
   * Get confirmationStatementOverdue
   * @return confirmationStatementOverdue
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getConfirmationStatementOverdue() {
    return confirmationStatementOverdue;
  }


  public void setConfirmationStatementOverdue(Boolean confirmationStatementOverdue) {
    
    
    
    this.confirmationStatementOverdue = confirmationStatementOverdue;
  }


  public CompaniesHouseGetCompanyDetailsResponse dateOfIncorporation(LocalDate dateOfIncorporation) {
    
    
    
    
    this.dateOfIncorporation = dateOfIncorporation;
    return this;
  }

   /**
   * ISO 8601 formatted date.
   * @return dateOfIncorporation
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "ISO 8601 formatted date.")

  public LocalDate getDateOfIncorporation() {
    return dateOfIncorporation;
  }


  public void setDateOfIncorporation(LocalDate dateOfIncorporation) {
    
    
    
    this.dateOfIncorporation = dateOfIncorporation;
  }


  public CompaniesHouseGetCompanyDetailsResponse entityRegistrationNumber(String entityRegistrationNumber) {
    
    
    if (entityRegistrationNumber != null && entityRegistrationNumber.length() < 1) {
      throw new IllegalArgumentException("Invalid value for entityRegistrationNumber. Length must be greater than or equal to 1.");
    }
    
    this.entityRegistrationNumber = entityRegistrationNumber;
    return this;
  }

   /**
   * The entity number assigned by the local register. For UK companies that&#39;s the Companies House company number.
   * @return entityRegistrationNumber
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The entity number assigned by the local register. For UK companies that's the Companies House company number.")

  public String getEntityRegistrationNumber() {
    return entityRegistrationNumber;
  }


  public void setEntityRegistrationNumber(String entityRegistrationNumber) {
    
    
    if (entityRegistrationNumber != null && entityRegistrationNumber.length() < 1) {
      throw new IllegalArgumentException("Invalid value for entityRegistrationNumber. Length must be greater than or equal to 1.");
    }
    this.entityRegistrationNumber = entityRegistrationNumber;
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
   * @return the CompaniesHouseGetCompanyDetailsResponse instance itself
   */
  public CompaniesHouseGetCompanyDetailsResponse putAdditionalProperty(String key, Object value) {
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
    CompaniesHouseGetCompanyDetailsResponse companiesHouseGetCompanyDetailsResponse = (CompaniesHouseGetCompanyDetailsResponse) o;
    return Objects.equals(this.companyAddress, companiesHouseGetCompanyDetailsResponse.companyAddress) &&
        Objects.equals(this.dateOfLatestAccounts, companiesHouseGetCompanyDetailsResponse.dateOfLatestAccounts) &&
        Objects.equals(this.entityName, companiesHouseGetCompanyDetailsResponse.entityName) &&
        Objects.equals(this.directors, companiesHouseGetCompanyDetailsResponse.directors) &&
        Objects.equals(this.dateOfLatestConfirmationStatement, companiesHouseGetCompanyDetailsResponse.dateOfLatestConfirmationStatement) &&
        Objects.equals(this.corporationType, companiesHouseGetCompanyDetailsResponse.corporationType) &&
        Objects.equals(this.companyStatus, companiesHouseGetCompanyDetailsResponse.companyStatus) &&
        Objects.equals(this.accountsOverdue, companiesHouseGetCompanyDetailsResponse.accountsOverdue) &&
        Objects.equals(this.sicCodes, companiesHouseGetCompanyDetailsResponse.sicCodes) &&
        Objects.equals(this.personsWithSignificantControl, companiesHouseGetCompanyDetailsResponse.personsWithSignificantControl) &&
        Objects.equals(this.confirmationStatementOverdue, companiesHouseGetCompanyDetailsResponse.confirmationStatementOverdue) &&
        Objects.equals(this.dateOfIncorporation, companiesHouseGetCompanyDetailsResponse.dateOfIncorporation) &&
        Objects.equals(this.entityRegistrationNumber, companiesHouseGetCompanyDetailsResponse.entityRegistrationNumber)&&
        Objects.equals(this.additionalProperties, companiesHouseGetCompanyDetailsResponse.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(companyAddress, dateOfLatestAccounts, entityName, directors, dateOfLatestConfirmationStatement, corporationType, companyStatus, accountsOverdue, sicCodes, personsWithSignificantControl, confirmationStatementOverdue, dateOfIncorporation, entityRegistrationNumber, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CompaniesHouseGetCompanyDetailsResponse {\n");
    sb.append("    companyAddress: ").append(toIndentedString(companyAddress)).append("\n");
    sb.append("    dateOfLatestAccounts: ").append(toIndentedString(dateOfLatestAccounts)).append("\n");
    sb.append("    entityName: ").append(toIndentedString(entityName)).append("\n");
    sb.append("    directors: ").append(toIndentedString(directors)).append("\n");
    sb.append("    dateOfLatestConfirmationStatement: ").append(toIndentedString(dateOfLatestConfirmationStatement)).append("\n");
    sb.append("    corporationType: ").append(toIndentedString(corporationType)).append("\n");
    sb.append("    companyStatus: ").append(toIndentedString(companyStatus)).append("\n");
    sb.append("    accountsOverdue: ").append(toIndentedString(accountsOverdue)).append("\n");
    sb.append("    sicCodes: ").append(toIndentedString(sicCodes)).append("\n");
    sb.append("    personsWithSignificantControl: ").append(toIndentedString(personsWithSignificantControl)).append("\n");
    sb.append("    confirmationStatementOverdue: ").append(toIndentedString(confirmationStatementOverdue)).append("\n");
    sb.append("    dateOfIncorporation: ").append(toIndentedString(dateOfIncorporation)).append("\n");
    sb.append("    entityRegistrationNumber: ").append(toIndentedString(entityRegistrationNumber)).append("\n");
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
    openapiFields.add("company-address");
    openapiFields.add("date-of-latest-accounts");
    openapiFields.add("entity-name");
    openapiFields.add("directors");
    openapiFields.add("date-of-latest-confirmation-statement");
    openapiFields.add("corporation-type");
    openapiFields.add("company-status");
    openapiFields.add("accounts-overdue");
    openapiFields.add("sic-codes");
    openapiFields.add("persons-with-significant-control");
    openapiFields.add("confirmation-statement-overdue");
    openapiFields.add("date-of-incorporation");
    openapiFields.add("entity-registration-number");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("entity-name");
    openapiRequiredFields.add("directors");
    openapiRequiredFields.add("corporation-type");
    openapiRequiredFields.add("company-status");
    openapiRequiredFields.add("persons-with-significant-control");
    openapiRequiredFields.add("date-of-incorporation");
    openapiRequiredFields.add("entity-registration-number");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to CompaniesHouseGetCompanyDetailsResponse
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!CompaniesHouseGetCompanyDetailsResponse.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in CompaniesHouseGetCompanyDetailsResponse is not found in the empty JSON string", CompaniesHouseGetCompanyDetailsResponse.openapiRequiredFields.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : CompaniesHouseGetCompanyDetailsResponse.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      // validate the optional field `company-address`
      if (jsonObj.get("company-address") != null && !jsonObj.get("company-address").isJsonNull()) {
        CompanyAddressProperty.validateJsonObject(jsonObj.getAsJsonObject("company-address"));
      }
      if (!jsonObj.get("entity-name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `entity-name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("entity-name").toString()));
      }
      // ensure the json data is an array
      if (!jsonObj.get("directors").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `directors` to be an array in the JSON string but got `%s`", jsonObj.get("directors").toString()));
      }

      JsonArray jsonArraydirectors = jsonObj.getAsJsonArray("directors");
      // validate the required field `directors` (array)
      for (int i = 0; i < jsonArraydirectors.size(); i++) {
        Director.validateJsonObject(jsonArraydirectors.get(i).getAsJsonObject());
      };
      if (!jsonObj.get("corporation-type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `corporation-type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("corporation-type").toString()));
      }
      if (!jsonObj.get("company-status").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `company-status` to be a primitive type in the JSON string but got `%s`", jsonObj.get("company-status").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("sic-codes") != null && !jsonObj.get("sic-codes").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `sic-codes` to be an array in the JSON string but got `%s`", jsonObj.get("sic-codes").toString()));
      }
      // ensure the json data is an array
      if (!jsonObj.get("persons-with-significant-control").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `persons-with-significant-control` to be an array in the JSON string but got `%s`", jsonObj.get("persons-with-significant-control").toString()));
      }

      JsonArray jsonArraypersonsWithSignificantControl = jsonObj.getAsJsonArray("persons-with-significant-control");
      // validate the required field `persons-with-significant-control` (array)
      for (int i = 0; i < jsonArraypersonsWithSignificantControl.size(); i++) {
        PersonWithSignificantControl.validateJsonObject(jsonArraypersonsWithSignificantControl.get(i).getAsJsonObject());
      };
      if (!jsonObj.get("entity-registration-number").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `entity-registration-number` to be a primitive type in the JSON string but got `%s`", jsonObj.get("entity-registration-number").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!CompaniesHouseGetCompanyDetailsResponse.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'CompaniesHouseGetCompanyDetailsResponse' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<CompaniesHouseGetCompanyDetailsResponse> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(CompaniesHouseGetCompanyDetailsResponse.class));

       return (TypeAdapter<T>) new TypeAdapter<CompaniesHouseGetCompanyDetailsResponse>() {
           @Override
           public void write(JsonWriter out, CompaniesHouseGetCompanyDetailsResponse value) throws IOException {
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
           public CompaniesHouseGetCompanyDetailsResponse read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             CompaniesHouseGetCompanyDetailsResponse instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of CompaniesHouseGetCompanyDetailsResponse given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of CompaniesHouseGetCompanyDetailsResponse
  * @throws IOException if the JSON string is invalid with respect to CompaniesHouseGetCompanyDetailsResponse
  */
  public static CompaniesHouseGetCompanyDetailsResponse fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, CompaniesHouseGetCompanyDetailsResponse.class);
  }

 /**
  * Convert an instance of CompaniesHouseGetCompanyDetailsResponse to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

