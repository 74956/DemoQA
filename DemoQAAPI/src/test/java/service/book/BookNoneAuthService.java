package service.book;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.*;
import org.apache.hc.core5.http.HttpStatus;
import service.base.BaseEndpoint;

import java.util.List;
import java.util.stream.Collectors;

public class BookNoneAuthService {

    private RequestSpecification requestSpecification;

    public BookNoneAuthService() {
        this.requestSpecification = getRequestSpecification();
    }

    public RequestSpecification getRequestSpecification(){
        String baseUrl = BaseEndpoint.SITE_URL.getPath();
        RequestSpecBuilder builder = new RequestSpecBuilder()
                .log(LogDetail.ALL)
                .setBaseUri(baseUrl)
                .setContentType(ContentType.JSON);
        requestSpecification = builder.build();
        return requestSpecification;
    }

    public Response getAllBooks() {
        String url = BookEndpoint.ALL_BOOKS.getUrl();
        return RestAssured
                .given()
                .spec(requestSpecification)
                .when()
                .get(url);
    }

    public AllBooksModal getBooks(){
        return getAllBooks()
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(AllBooksModal.class);
    }

    public String getBookIsbn(AllBooksModal allBooksModal, String bookName){
        List<String> isbnList = allBooksModal.getBooks().stream().filter(bookModal -> bookModal.getTitle().
                equals(bookName)).map(BookModal::getIsbn).collect(Collectors.toList());
        return isbnList.stream().findAny().get();
    }

}
