# RolesApi

All URIs are relative to *https://api.griffin.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**assignMembershipRoles**](RolesApi.md#assignMembershipRoles) | **PUT** /v0/memberships/{membership-id}/roles | Update role |
| [**getMembershipRoles**](RolesApi.md#getMembershipRoles) | **GET** /v0/memberships/{membership-id}/roles | List membership roles |
| [**getRole**](RolesApi.md#getRole) | **GET** /v0/roles/{role-id} | Get role |
| [**listAllRoles**](RolesApi.md#listAllRoles) | **GET** /v0/roles | List roles |


<a name="assignMembershipRoles"></a>
# **assignMembershipRoles**
> RolesAssignMembershipRolesResponse assignMembershipRoles(membershipId, rolesAssignMembershipRolesRequest).execute();

Update role

Assigns [roles](http://docs.griffin.com) to the [membership](http://docs.griffin.com).  A 422 is served if you provide a role that is not in the [Organisations](http://docs.griffin.com) &#x60;\&quot;available-roles\&quot;&#x60;.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.RolesApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    List<String> roleUrls = Arrays.asList();
    String membershipId = "membershipId_example";
    try {
      RolesAssignMembershipRolesResponse result = client
              .roles
              .assignMembershipRoles(roleUrls, membershipId)
              .execute();
      System.out.println(result);
      System.out.println(result.getRoles());
    } catch (ApiException e) {
      System.err.println("Exception when calling RolesApi#assignMembershipRoles");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<RolesAssignMembershipRolesResponse> response = client
              .roles
              .assignMembershipRoles(roleUrls, membershipId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling RolesApi#assignMembershipRoles");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **membershipId** | **String**|  | |
| **rolesAssignMembershipRolesRequest** | [**RolesAssignMembershipRolesRequest**](RolesAssignMembershipRolesRequest.md)|  | |

### Return type

[**RolesAssignMembershipRolesResponse**](RolesAssignMembershipRolesResponse.md)

### Authorization

[api-key-auth](../README.md#api-key-auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |
| **400** |  |  -  |
| **401** | Requires an API key to continue |  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  |
| **404** |  |  -  |
| **422** |  |  -  |

<a name="getMembershipRoles"></a>
# **getMembershipRoles**
> RolesGetMembershipRolesResponse getMembershipRoles(membershipId).execute();

List membership roles

Returns the [roles](http://docs.griffin.com) assigned to this [membership](http://docs.griffin.com).

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.RolesApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    
    configuration.apiKeyAuth  = "YOUR API KEY";
    Griffin client = new Griffin(configuration);
    String membershipId = "membershipId_example";
    try {
      RolesGetMembershipRolesResponse result = client
              .roles
              .getMembershipRoles(membershipId)
              .execute();
      System.out.println(result);
      System.out.println(result.getRoles());
    } catch (ApiException e) {
      System.err.println("Exception when calling RolesApi#getMembershipRoles");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<RolesGetMembershipRolesResponse> response = client
              .roles
              .getMembershipRoles(membershipId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling RolesApi#getMembershipRoles");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **membershipId** | **String**|  | |

### Return type

[**RolesGetMembershipRolesResponse**](RolesGetMembershipRolesResponse.md)

### Authorization

[api-key-auth](../README.md#api-key-auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |
| **400** |  |  -  |
| **401** | Requires an API key to continue |  * www-authenticate - Returns &#x60;GriffinSession&#x60; if no valid authentication is found. <br>  |

<a name="getRole"></a>
# **getRole**
> RolesGetRoleResponse getRole(roleId).execute();

Get role

Yields the Role resource.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.RolesApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    Griffin client = new Griffin(configuration);
    String roleId = "roleId_example";
    try {
      RolesGetRoleResponse result = client
              .roles
              .getRole(roleId)
              .execute();
      System.out.println(result);
      System.out.println(result.getDescription());
      System.out.println(result.getDisplayName());
      System.out.println(result.getRoleUrl());
    } catch (ApiException e) {
      System.err.println("Exception when calling RolesApi#getRole");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<RolesGetRoleResponse> response = client
              .roles
              .getRole(roleId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling RolesApi#getRole");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **roleId** | **String**|  | |

### Return type

[**RolesGetRoleResponse**](RolesGetRoleResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |
| **400** |  |  -  |
| **404** |  |  -  |

<a name="listAllRoles"></a>
# **listAllRoles**
> RolesListAllRolesResponse listAllRoles().execute();

List roles

Yields a list of all Role resources.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Griffin;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.RolesApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.griffin.com";
    Griffin client = new Griffin(configuration);
    try {
      RolesListAllRolesResponse result = client
              .roles
              .listAllRoles()
              .execute();
      System.out.println(result);
      System.out.println(result.getRoles());
    } catch (ApiException e) {
      System.err.println("Exception when calling RolesApi#listAllRoles");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<RolesListAllRolesResponse> response = client
              .roles
              .listAllRoles()
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling RolesApi#listAllRoles");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters
This endpoint does not need any parameter.

### Return type

[**RolesListAllRolesResponse**](RolesListAllRolesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |

