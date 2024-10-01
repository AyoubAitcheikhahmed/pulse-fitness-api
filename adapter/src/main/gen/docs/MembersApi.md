# MembersApi

All URIs are relative to *http://api.pulse.com/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createMember**](MembersApi.md#createMember) | **POST** /members | Create a new member |
| [**getMemberById**](MembersApi.md#getMemberById) | **GET** /members/{memberId} | Get member details by ID |
| [**listMembers**](MembersApi.md#listMembers) | **GET** /members | List all members |


<a id="createMember"></a>
# **createMember**
> createMember(member)

Create a new member

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.MembersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://api.pulse.com/v1");

    MembersApi apiInstance = new MembersApi(defaultClient);
    Member member = new Member(); // Member | 
    try {
      apiInstance.createMember(member);
    } catch (ApiException e) {
      System.err.println("Exception when calling MembersApi#createMember");
      System.err.println("Status code: " + e.getCode());
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
| **member** | [**Member**](Member.md)|  | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Member successfully created |  -  |
| **0** | unexpected error |  -  |

<a id="getMemberById"></a>
# **getMemberById**
> Member getMemberById(memberId)

Get member details by ID

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.MembersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://api.pulse.com/v1");

    MembersApi apiInstance = new MembersApi(defaultClient);
    String memberId = "memberId_example"; // String | The ID of the member to retrieve
    try {
      Member result = apiInstance.getMemberById(memberId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MembersApi#getMemberById");
      System.err.println("Status code: " + e.getCode());
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
| **memberId** | **String**| The ID of the member to retrieve | |

### Return type

[**Member**](Member.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Member details retrieved successfully |  -  |
| **0** | unexpected error |  -  |

<a id="listMembers"></a>
# **listMembers**
> List&lt;Member&gt; listMembers(limit)

List all members

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.MembersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://api.pulse.com/v1");

    MembersApi apiInstance = new MembersApi(defaultClient);
    Integer limit = 56; // Integer | How many members to return at one time (max 100)
    try {
      List<Member> result = apiInstance.listMembers(limit);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MembersApi#listMembers");
      System.err.println("Status code: " + e.getCode());
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
| **limit** | **Integer**| How many members to return at one time (max 100) | [optional] |

### Return type

[**List&lt;Member&gt;**](Member.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A paged array of members |  * x-next - A link to the next page of responses <br>  |
| **0** | unexpected error |  -  |

