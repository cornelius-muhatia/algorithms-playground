/*
 * Copyright 2019 Cornelius M.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cmuhatia.playground.rxjava;


import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;

import java.util.ArrayList;

/**
 * @author Cornelius M.
 * @version 1.0.0, 03/06/2020
 */
public class RxJavaPrototype {

    public static void main(String[] args){
        ArrayList<String> items = new ArrayList<>();
        items.add("Hello World");
        Observable<String> rxHello = Observable.fromIterable(items);
        rxHello.subscribe(System.out::println);
        items.add("Howdy :)");

//        ObservableEmitter<String> emitter = new ObservableEmitter
//        rxHello = Observable.create(emitter);
//        rxHello.publish(() ->{});
    }
}
