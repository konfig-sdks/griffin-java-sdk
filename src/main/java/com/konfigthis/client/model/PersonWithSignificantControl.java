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
 * PersonWithSignificantControl
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class PersonWithSignificantControl {
  public static final String SERIALIZED_NAME_DISPLAY_NAME = "display-name";
  @SerializedName(SERIALIZED_NAME_DISPLAY_NAME)
  private String displayName;

  /**
   * Gets or Sets naturesOfControl
   */
  @JsonAdapter(NaturesOfControlEnum.Adapter.class)
 public enum NaturesOfControlEnum {
    VOTING_RIGHTS_25_TO_50_PERCENT_LIMITED_LIABILITY_PARTNERSHIP("voting-rights-25-to-50-percent-limited-liability-partnership"),
    
    RIGHT_TO_APPOINT_AND_REMOVE_MEMBERS_LIMITED_LIABILITY_PARTNERSHIP("right-to-appoint-and-remove-members-limited-liability-partnership"),
    
    PART_RIGHT_TO_SHARE_SURPLUS_ASSETS_75_TO_100_PERCENT_AS_TRUST("part-right-to-share-surplus-assets-75-to-100-percent-as-trust"),
    
    OWNERSHIP_OF_SHARES_MORE_THAN_25_PERCENT_REGISTERED_OVERSEAS_ENTITY("ownership-of-shares-more-than-25-percent-registered-overseas-entity"),
    
    PART_RIGHT_TO_SHARE_SURPLUS_ASSETS_50_TO_75_PERCENT_AS_TRUST("part-right-to-share-surplus-assets-50-to-75-percent-as-trust"),
    
    SIGNIFICANT_INFLUENCE_OR_CONTROL_AS_FIRM_LIMITED_LIABILITY_PARTNERSHIP("significant-influence-or-control-as-firm-limited-liability-partnership"),
    
    PART_RIGHT_TO_SHARE_SURPLUS_ASSETS_25_TO_50_PERCENT_AS_FIRM("part-right-to-share-surplus-assets-25-to-50-percent-as-firm"),
    
    OWNERSHIP_OF_SHARES_25_TO_50_PERCENT_AS_TRUST("ownership-of-shares-25-to-50-percent-as-trust"),
    
    OWNERSHIP_OF_SHARES_MORE_THAN_25_PERCENT_AS_FIRM_REGISTERED_OVERSEAS_ENTITY("ownership-of-shares-more-than-25-percent-as-firm-registered-overseas-entity"),
    
    VOTING_RIGHTS_25_TO_50_PERCENT("voting-rights-25-to-50-percent"),
    
    VOTING_RIGHTS_25_TO_50_PERCENT_AS_FIRM("voting-rights-25-to-50-percent-as-firm"),
    
    OWNERSHIP_OF_SHARES_MORE_THAN_25_PERCENT_AS_TRUST_REGISTERED_OVERSEAS_ENTITY("ownership-of-shares-more-than-25-percent-as-trust-registered-overseas-entity"),
    
    SIGNIFICANT_INFLUENCE_OR_CONTROL("significant-influence-or-control"),
    
    SIGNIFICANT_INFLUENCE_OR_CONTROL_REGISTERED_OVERSEAS_ENTITY("significant-influence-or-control-registered-overseas-entity"),
    
    PART_RIGHT_TO_SHARE_SURPLUS_ASSETS_50_TO_75_PERCENT_AS_FIRM("part-right-to-share-surplus-assets-50-to-75-percent-as-firm"),
    
    VOTING_RIGHTS_50_TO_75_PERCENT("voting-rights-50-to-75-percent"),
    
    PART_RIGHT_TO_SHARE_SURPLUS_ASSETS_25_TO_50_PERCENT("part-right-to-share-surplus-assets-25-to-50-percent"),
    
    VOTING_RIGHTS_50_TO_75_PERCENT_AS_TRUST("voting-rights-50-to-75-percent-as-trust"),
    
    RIGHT_TO_SHARE_SURPLUS_ASSETS_75_TO_100_PERCENT_AS_FIRM_LIMITED_LIABILITY_PARTNERSHIP("right-to-share-surplus-assets-75-to-100-percent-as-firm-limited-liability-partnership"),
    
    RIGHT_TO_APPOINT_AND_REMOVE_PERSON_AS_TRUST("right-to-appoint-and-remove-person-as-trust"),
    
    OWNERSHIP_OF_SHARES_50_TO_75_PERCENT_AS_FIRM("ownership-of-shares-50-to-75-percent-as-firm"),
    
    VOTING_RIGHTS_50_TO_75_PERCENT_AS_FIRM_LIMITED_LIABILITY_PARTNERSHIP("voting-rights-50-to-75-percent-as-firm-limited-liability-partnership"),
    
    VOTING_RIGHTS_25_TO_50_PERCENT_AS_TRUST("voting-rights-25-to-50-percent-as-trust"),
    
    VOTING_RIGHTS_50_TO_75_PERCENT_AS_TRUST_LIMITED_LIABILITY_PARTNERSHIP("voting-rights-50-to-75-percent-as-trust-limited-liability-partnership"),
    
    VOTING_RIGHTS_75_TO_100_PERCENT("voting-rights-75-to-100-percent"),
    
    PART_RIGHT_TO_SHARE_SURPLUS_ASSETS_75_TO_100_PERCENT_AS_FIRM("part-right-to-share-surplus-assets-75-to-100-percent-as-firm"),
    
    SIGNIFICANT_INFLUENCE_OR_CONTROL_LIMITED_LIABILITY_PARTNERSHIP("significant-influence-or-control-limited-liability-partnership"),
    
    RIGHT_TO_SHARE_SURPLUS_ASSETS_75_TO_100_PERCENT_LIMITED_LIABILITY_PARTNERSHIP("right-to-share-surplus-assets-75-to-100-percent-limited-liability-partnership"),
    
    RIGHT_TO_APPOINT_AND_REMOVE_DIRECTORS_AS_FIRM("right-to-appoint-and-remove-directors-as-firm"),
    
    VOTING_RIGHTS_75_TO_100_PERCENT_AS_TRUST("voting-rights-75-to-100-percent-as-trust"),
    
    VOTING_RIGHTS_25_TO_50_PERCENT_AS_FIRM_LIMITED_LIABILITY_PARTNERSHIP("voting-rights-25-to-50-percent-as-firm-limited-liability-partnership"),
    
    RIGHT_TO_APPOINT_AND_REMOVE_DIRECTORS_AS_FIRM_REGISTERED_OVERSEAS_ENTITY("right-to-appoint-and-remove-directors-as-firm-registered-overseas-entity"),
    
    RIGHT_TO_SHARE_SURPLUS_ASSETS_25_TO_50_PERCENT_AS_FIRM_LIMITED_LIABILITY_PARTNERSHIP("right-to-share-surplus-assets-25-to-50-percent-as-firm-limited-liability-partnership"),
    
    OWNERSHIP_OF_SHARES_25_TO_50_PERCENT("ownership-of-shares-25-to-50-percent"),
    
    OWNERSHIP_OF_SHARES_75_TO_100_PERCENT_AS_FIRM("ownership-of-shares-75-to-100-percent-as-firm"),
    
    SIGNIFICANT_INFLUENCE_OR_CONTROL_AS_FIRM("significant-influence-or-control-as-firm"),
    
    RIGHT_TO_APPOINT_AND_REMOVE_DIRECTORS_AS_TRUST("right-to-appoint-and-remove-directors-as-trust"),
    
    RIGHT_TO_APPOINT_AND_REMOVE_PERSON("right-to-appoint-and-remove-person"),
    
    SIGNIFICANT_INFLUENCE_OR_CONTROL_AS_TRUST_REGISTERED_OVERSEAS_ENTITY("significant-influence-or-control-as-trust-registered-overseas-entity"),
    
    VOTING_RIGHTS_MORE_THAN_25_PERCENT_AS_TRUST_REGISTERED_OVERSEAS_ENTITY("voting-rights-more-than-25-percent-as-trust-registered-overseas-entity"),
    
    RIGHT_TO_APPOINT_AND_REMOVE_DIRECTORS_AS_TRUST_REGISTERED_OVERSEAS_ENTITY("right-to-appoint-and-remove-directors-as-trust-registered-overseas-entity"),
    
    RIGHT_TO_APPOINT_AND_REMOVE_MEMBERS_AS_FIRM_LIMITED_LIABILITY_PARTNERSHIP("right-to-appoint-and-remove-members-as-firm-limited-liability-partnership"),
    
    PART_RIGHT_TO_SHARE_SURPLUS_ASSETS_75_TO_100_PERCENT("part-right-to-share-surplus-assets-75-to-100-percent"),
    
    OWNERSHIP_OF_SHARES_25_TO_50_PERCENT_AS_FIRM("ownership-of-shares-25-to-50-percent-as-firm"),
    
    RIGHT_TO_SHARE_SURPLUS_ASSETS_25_TO_50_PERCENT_AS_TRUST_LIMITED_LIABILITY_PARTNERSHIP("right-to-share-surplus-assets-25-to-50-percent-as-trust-limited-liability-partnership"),
    
    RIGHT_TO_SHARE_SURPLUS_ASSETS_50_TO_75_PERCENT_LIMITED_LIABILITY_PARTNERSHIP("right-to-share-surplus-assets-50-to-75-percent-limited-liability-partnership"),
    
    VOTING_RIGHTS_50_TO_75_PERCENT_AS_FIRM("voting-rights-50-to-75-percent-as-firm"),
    
    PART_RIGHT_TO_SHARE_SURPLUS_ASSETS_50_TO_75_PERCENT("part-right-to-share-surplus-assets-50-to-75-percent"),
    
    RIGHT_TO_APPOINT_AND_REMOVE_DIRECTORS_REGISTERED_OVERSEAS_ENTITY("right-to-appoint-and-remove-directors-registered-overseas-entity"),
    
    SIGNIFICANT_INFLUENCE_OR_CONTROL_AS_TRUST("significant-influence-or-control-as-trust"),
    
    RIGHT_TO_SHARE_SURPLUS_ASSETS_75_TO_100_PERCENT_AS_TRUST_LIMITED_LIABILITY_PARTNERSHIP("right-to-share-surplus-assets-75-to-100-percent-as-trust-limited-liability-partnership"),
    
    OWNERSHIP_OF_SHARES_50_TO_75_PERCENT_AS_TRUST("ownership-of-shares-50-to-75-percent-as-trust"),
    
    RIGHT_TO_SHARE_SURPLUS_ASSETS_50_TO_75_PERCENT_AS_FIRM_LIMITED_LIABILITY_PARTNERSHIP("right-to-share-surplus-assets-50-to-75-percent-as-firm-limited-liability-partnership"),
    
    VOTING_RIGHTS_MORE_THAN_25_PERCENT_AS_FIRM_REGISTERED_OVERSEAS_ENTITY("voting-rights-more-than-25-percent-as-firm-registered-overseas-entity"),
    
    SIGNIFICANT_INFLUENCE_OR_CONTROL_AS_FIRM_REGISTERED_OVERSEAS_ENTITY("significant-influence-or-control-as-firm-registered-overseas-entity"),
    
    OWNERSHIP_OF_SHARES_75_TO_100_PERCENT_AS_TRUST("ownership-of-shares-75-to-100-percent-as-trust"),
    
    OWNERSHIP_OF_SHARES_50_TO_75_PERCENT("ownership-of-shares-50-to-75-percent"),
    
    RIGHT_TO_SHARE_SURPLUS_ASSETS_50_TO_75_PERCENT_AS_TRUST_LIMITED_LIABILITY_PARTNERSHIP("right-to-share-surplus-assets-50-to-75-percent-as-trust-limited-liability-partnership"),
    
    VOTING_RIGHTS_75_TO_100_PERCENT_LIMITED_LIABILITY_PARTNERSHIP("voting-rights-75-to-100-percent-limited-liability-partnership"),
    
    VOTING_RIGHTS_MORE_THAN_25_PERCENT_REGISTERED_OVERSEAS_ENTITY("voting-rights-more-than-25-percent-registered-overseas-entity"),
    
    RIGHT_TO_APPOINT_AND_REMOVE_MEMBERS_AS_TRUST_LIMITED_LIABILITY_PARTNERSHIP("right-to-appoint-and-remove-members-as-trust-limited-liability-partnership"),
    
    OWNERSHIP_OF_SHARES_75_TO_100_PERCENT("ownership-of-shares-75-to-100-percent"),
    
    PART_RIGHT_TO_SHARE_SURPLUS_ASSETS_25_TO_50_PERCENT_AS_TRUST("part-right-to-share-surplus-assets-25-to-50-percent-as-trust"),
    
    VOTING_RIGHTS_75_TO_100_PERCENT_AS_TRUST_LIMITED_LIABILITY_PARTNERSHIP("voting-rights-75-to-100-percent-as-trust-limited-liability-partnership"),
    
    VOTING_RIGHTS_50_TO_75_PERCENT_LIMITED_LIABILITY_PARTNERSHIP("voting-rights-50-to-75-percent-limited-liability-partnership"),
    
    SIGNIFICANT_INFLUENCE_OR_CONTROL_AS_TRUST_LIMITED_LIABILITY_PARTNERSHIP("significant-influence-or-control-as-trust-limited-liability-partnership"),
    
    VOTING_RIGHTS_75_TO_100_PERCENT_AS_FIRM_LIMITED_LIABILITY_PARTNERSHIP("voting-rights-75-to-100-percent-as-firm-limited-liability-partnership"),
    
    RIGHT_TO_APPOINT_AND_REMOVE_PERSON_AS_FIRM("right-to-appoint-and-remove-person-as-firm"),
    
    RIGHT_TO_APPOINT_AND_REMOVE_DIRECTORS("right-to-appoint-and-remove-directors"),
    
    VOTING_RIGHTS_25_TO_50_PERCENT_AS_TRUST_LIMITED_LIABILITY_PARTNERSHIP("voting-rights-25-to-50-percent-as-trust-limited-liability-partnership"),
    
    VOTING_RIGHTS_75_TO_100_PERCENT_AS_FIRM("voting-rights-75-to-100-percent-as-firm"),
    
    RIGHT_TO_SHARE_SURPLUS_ASSETS_25_TO_50_PERCENT_LIMITED_LIABILITY_PARTNERSHIP("right-to-share-surplus-assets-25-to-50-percent-limited-liability-partnership");

    private String value;

    NaturesOfControlEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static NaturesOfControlEnum fromValue(String value) {
      for (NaturesOfControlEnum b : NaturesOfControlEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<NaturesOfControlEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final NaturesOfControlEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public NaturesOfControlEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return NaturesOfControlEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_NATURES_OF_CONTROL = "natures-of-control";
  @SerializedName(SERIALIZED_NAME_NATURES_OF_CONTROL)
  private List<NaturesOfControlEnum> naturesOfControl = new ArrayList<>();

  public static final String SERIALIZED_NAME_COMPANIES_HOUSE_URL = "companies-house-url";
  @SerializedName(SERIALIZED_NAME_COMPANIES_HOUSE_URL)
  private String companiesHouseUrl;

  public static final String SERIALIZED_NAME_GIVEN_NAME = "given-name";
  @SerializedName(SERIALIZED_NAME_GIVEN_NAME)
  private String givenName;

  public static final String SERIALIZED_NAME_SURNAME = "surname";
  @SerializedName(SERIALIZED_NAME_SURNAME)
  private String surname;

  public static final String SERIALIZED_NAME_DAY_OF_BIRTH = "day-of-birth";
  @SerializedName(SERIALIZED_NAME_DAY_OF_BIRTH)
  private Long dayOfBirth;

  public static final String SERIALIZED_NAME_MONTH_OF_BIRTH = "month-of-birth";
  @SerializedName(SERIALIZED_NAME_MONTH_OF_BIRTH)
  private Long monthOfBirth;

  public static final String SERIALIZED_NAME_YEAR_OF_BIRTH = "year-of-birth";
  @SerializedName(SERIALIZED_NAME_YEAR_OF_BIRTH)
  private Long yearOfBirth;

  public PersonWithSignificantControl() {
  }

  public PersonWithSignificantControl displayName(String displayName) {
    
    
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


  public PersonWithSignificantControl naturesOfControl(List<NaturesOfControlEnum> naturesOfControl) {
    
    
    
    
    this.naturesOfControl = naturesOfControl;
    return this;
  }

  public PersonWithSignificantControl addNaturesOfControlItem(NaturesOfControlEnum naturesOfControlItem) {
    this.naturesOfControl.add(naturesOfControlItem);
    return this;
  }

   /**
   * Get naturesOfControl
   * @return naturesOfControl
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public List<NaturesOfControlEnum> getNaturesOfControl() {
    return naturesOfControl;
  }


  public void setNaturesOfControl(List<NaturesOfControlEnum> naturesOfControl) {
    
    
    
    this.naturesOfControl = naturesOfControl;
  }


  public PersonWithSignificantControl companiesHouseUrl(String companiesHouseUrl) {
    
    
    
    
    this.companiesHouseUrl = companiesHouseUrl;
    return this;
  }

   /**
   * The URL of the entity in Companies House
   * @return companiesHouseUrl
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "https://api.company-information.service.gov.uk/company/00000001/appointments/AbcDEFGhI1JKLmnO2PQ3sTUv4WX", required = true, value = "The URL of the entity in Companies House")

  public String getCompaniesHouseUrl() {
    return companiesHouseUrl;
  }


  public void setCompaniesHouseUrl(String companiesHouseUrl) {
    
    
    
    this.companiesHouseUrl = companiesHouseUrl;
  }


  public PersonWithSignificantControl givenName(String givenName) {
    
    
    
    
    this.givenName = givenName;
    return this;
  }

   /**
   * Get givenName
   * @return givenName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getGivenName() {
    return givenName;
  }


  public void setGivenName(String givenName) {
    
    
    
    this.givenName = givenName;
  }


  public PersonWithSignificantControl surname(String surname) {
    
    
    
    
    this.surname = surname;
    return this;
  }

   /**
   * Get surname
   * @return surname
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getSurname() {
    return surname;
  }


  public void setSurname(String surname) {
    
    
    
    this.surname = surname;
  }


  public PersonWithSignificantControl dayOfBirth(Long dayOfBirth) {
    if (dayOfBirth != null && dayOfBirth < 1) {
      throw new IllegalArgumentException("Invalid value for dayOfBirth. Must be greater than or equal to 1.");
    }
    
    
    
    this.dayOfBirth = dayOfBirth;
    return this;
  }

   /**
   * Get dayOfBirth
   * minimum: 1
   * @return dayOfBirth
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Long getDayOfBirth() {
    return dayOfBirth;
  }


  public void setDayOfBirth(Long dayOfBirth) {
    if (dayOfBirth != null && dayOfBirth < 1) {
      throw new IllegalArgumentException("Invalid value for dayOfBirth. Must be greater than or equal to 1.");
    }
    
    
    this.dayOfBirth = dayOfBirth;
  }


  public PersonWithSignificantControl monthOfBirth(Long monthOfBirth) {
    if (monthOfBirth != null && monthOfBirth < 1) {
      throw new IllegalArgumentException("Invalid value for monthOfBirth. Must be greater than or equal to 1.");
    }
    
    
    
    this.monthOfBirth = monthOfBirth;
    return this;
  }

   /**
   * Get monthOfBirth
   * minimum: 1
   * @return monthOfBirth
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Long getMonthOfBirth() {
    return monthOfBirth;
  }


  public void setMonthOfBirth(Long monthOfBirth) {
    if (monthOfBirth != null && monthOfBirth < 1) {
      throw new IllegalArgumentException("Invalid value for monthOfBirth. Must be greater than or equal to 1.");
    }
    
    
    this.monthOfBirth = monthOfBirth;
  }


  public PersonWithSignificantControl yearOfBirth(Long yearOfBirth) {
    if (yearOfBirth != null && yearOfBirth < 1) {
      throw new IllegalArgumentException("Invalid value for yearOfBirth. Must be greater than or equal to 1.");
    }
    
    
    
    this.yearOfBirth = yearOfBirth;
    return this;
  }

   /**
   * Get yearOfBirth
   * minimum: 1
   * @return yearOfBirth
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Long getYearOfBirth() {
    return yearOfBirth;
  }


  public void setYearOfBirth(Long yearOfBirth) {
    if (yearOfBirth != null && yearOfBirth < 1) {
      throw new IllegalArgumentException("Invalid value for yearOfBirth. Must be greater than or equal to 1.");
    }
    
    
    this.yearOfBirth = yearOfBirth;
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
   * @return the PersonWithSignificantControl instance itself
   */
  public PersonWithSignificantControl putAdditionalProperty(String key, Object value) {
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
    PersonWithSignificantControl personWithSignificantControl = (PersonWithSignificantControl) o;
    return Objects.equals(this.displayName, personWithSignificantControl.displayName) &&
        Objects.equals(this.naturesOfControl, personWithSignificantControl.naturesOfControl) &&
        Objects.equals(this.companiesHouseUrl, personWithSignificantControl.companiesHouseUrl) &&
        Objects.equals(this.givenName, personWithSignificantControl.givenName) &&
        Objects.equals(this.surname, personWithSignificantControl.surname) &&
        Objects.equals(this.dayOfBirth, personWithSignificantControl.dayOfBirth) &&
        Objects.equals(this.monthOfBirth, personWithSignificantControl.monthOfBirth) &&
        Objects.equals(this.yearOfBirth, personWithSignificantControl.yearOfBirth)&&
        Objects.equals(this.additionalProperties, personWithSignificantControl.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(displayName, naturesOfControl, companiesHouseUrl, givenName, surname, dayOfBirth, monthOfBirth, yearOfBirth, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonWithSignificantControl {\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    naturesOfControl: ").append(toIndentedString(naturesOfControl)).append("\n");
    sb.append("    companiesHouseUrl: ").append(toIndentedString(companiesHouseUrl)).append("\n");
    sb.append("    givenName: ").append(toIndentedString(givenName)).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    dayOfBirth: ").append(toIndentedString(dayOfBirth)).append("\n");
    sb.append("    monthOfBirth: ").append(toIndentedString(monthOfBirth)).append("\n");
    sb.append("    yearOfBirth: ").append(toIndentedString(yearOfBirth)).append("\n");
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
    openapiFields.add("display-name");
    openapiFields.add("natures-of-control");
    openapiFields.add("companies-house-url");
    openapiFields.add("given-name");
    openapiFields.add("surname");
    openapiFields.add("day-of-birth");
    openapiFields.add("month-of-birth");
    openapiFields.add("year-of-birth");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("display-name");
    openapiRequiredFields.add("natures-of-control");
    openapiRequiredFields.add("companies-house-url");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to PersonWithSignificantControl
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!PersonWithSignificantControl.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in PersonWithSignificantControl is not found in the empty JSON string", PersonWithSignificantControl.openapiRequiredFields.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : PersonWithSignificantControl.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if (!jsonObj.get("display-name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `display-name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("display-name").toString()));
      }
      // ensure the required json array is present
      if (jsonObj.get("natures-of-control") == null) {
        throw new IllegalArgumentException("Expected the field `linkedContent` to be an array in the JSON string but got `null`");
      } else if (!jsonObj.get("natures-of-control").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `natures-of-control` to be an array in the JSON string but got `%s`", jsonObj.get("natures-of-control").toString()));
      }
      if (!jsonObj.get("companies-house-url").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `companies-house-url` to be a primitive type in the JSON string but got `%s`", jsonObj.get("companies-house-url").toString()));
      }
      if ((jsonObj.get("given-name") != null && !jsonObj.get("given-name").isJsonNull()) && !jsonObj.get("given-name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `given-name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("given-name").toString()));
      }
      if ((jsonObj.get("surname") != null && !jsonObj.get("surname").isJsonNull()) && !jsonObj.get("surname").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `surname` to be a primitive type in the JSON string but got `%s`", jsonObj.get("surname").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!PersonWithSignificantControl.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'PersonWithSignificantControl' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<PersonWithSignificantControl> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(PersonWithSignificantControl.class));

       return (TypeAdapter<T>) new TypeAdapter<PersonWithSignificantControl>() {
           @Override
           public void write(JsonWriter out, PersonWithSignificantControl value) throws IOException {
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
           public PersonWithSignificantControl read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             PersonWithSignificantControl instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of PersonWithSignificantControl given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of PersonWithSignificantControl
  * @throws IOException if the JSON string is invalid with respect to PersonWithSignificantControl
  */
  public static PersonWithSignificantControl fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, PersonWithSignificantControl.class);
  }

 /**
  * Convert an instance of PersonWithSignificantControl to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

