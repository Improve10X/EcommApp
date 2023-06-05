package com.improve10x.ecommapp;

import org.junit.Test;

import static org.junit.Assert.*;

import com.google.gson.Gson;
import com.improve10x.ecommapp.models.CartProductLists;
import com.improve10x.ecommapp.models.CartProducts;
import com.improve10x.ecommapp.models.Categories;
import com.improve10x.ecommapp.models.Products;
import com.improve10x.ecommapp.network.FakeApi;
import com.improve10x.ecommapp.network.FakeApiService;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void getCategories() throws IOException {
        FakeApi fakeApi = new FakeApi();
        FakeApiService  fakeApiService = fakeApi.createFakeApiService();
        Call<List<Categories>> call = fakeApiService.getCategories();
        List<Categories> categories = call.execute().body();
        assertNotNull(categories);
        assertFalse(categories.isEmpty());
        System.out.println(new Gson().toJson(categories));
    }
    @Test
    public void getProducts() throws IOException{
        FakeApi fakeApi = new FakeApi();
        FakeApiService  fakeApiService = fakeApi.createFakeApiService();
        Call<List<Products>> call = fakeApiService.getProducts("1");
        List<Products> products = call.execute().body();
        assertNotNull(products);
        //assertFalse(products.isEmpty());
        System.out.println(new Gson().toJson(products));
    }

    @Test
    public void getCart() throws IOException{
        FakeApi fakeApi = new FakeApi();
        FakeApiService  fakeApiService = fakeApi.createFakeApiService();
        Call<CartProducts> call = fakeApiService.fetchCarts();
        CartProducts cartProducts = call.execute().body();
        assertNotNull(cartProducts);
        System.out.println(new Gson().toJson(cartProducts));

    }
}