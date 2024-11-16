package com.Challenge.AluraGutendex.Service;

public interface IConvertData {

    <T> T getData(String json, Class<T> clazz);

}
