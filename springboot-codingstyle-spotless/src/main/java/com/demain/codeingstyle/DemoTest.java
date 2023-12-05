/*
 * Copyright (c) 2023, demain_lee (lmm_work@163.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.demain.codeingstyle;

import java.util.Arrays;
import java.util.List;

public class DemoTest {
    
    public static void test() {
        List<String> list1 = Arrays.asList("a", "b", "c");
        List<String> list2 = Arrays.asList("d", "e", "f");
        list1.forEach(System.out::println);
        list2.forEach(System.out::println);
    }
    
    /**
     * 测试
     *
     * @param a
     *            数值a
     * @param b
     *            数值b
     */
    public static void test2(Integer a, Integer b) {
        System.out.println(a);
        System.out.println(b);
    }
    
    public static void main(String[] args) {
        test();
        test2(1, 2);
        int a = 1 + 2;
        System.out.println(a);
    }
}
