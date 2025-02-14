package com.springreactive.firstproject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import reactor.util.function.Tuple2;

import javax.management.monitor.MonitorNotification;
import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

@SpringBootTest
class FirstprojectApplicationTests {

	@Test
	void contextLoads() {


	}

	@Test
	void test() throws InterruptedException {
		Mono<String> m1 = Mono.just("bharat naik").log();
		Mono<Integer> m2 = Mono.just(1);


//		Mono<Tuple2<String, String>> m3 = Mono.zip(m1, m2);
		// Modifies the data inside the mono
//		Mono<String> m4 = m1.map(String::toUpperCase);  // method reference

//		m4.subscribe(data -> {
//			System.out.println(data);
////			System.out.println(data.getT2());
//		});

		// Transform the mono and return a new mono
//		Mono<String[]> m5 = m1.flatMap(data -> Mono.just(data.split(" "))).delayElement(Duration.ofSeconds(2));
//		m5.subscribe(data -> {
//			System.out.println(Thread.currentThread().getName());
//			for (int i = 0; i < data.length; i++) {
//				System.out.println(data[i]);
//			}
//		});
//		Thread.sleep(5000);

//		// Transform the mono and return a new flux
//		System.out.println(Thread.currentThread().getName());
//		Flux<String> f1 = m1.flatMapMany(data -> Flux.just(data.split(" "))).delayElements(Duration.ofSeconds(2));
//		StepVerifier.create(f1).expectNextCount(2).verifyComplete();
//		f1.subscribe(data -> {
//			System.out.println(Thread.currentThread().getName());
//			System.out.println(data);
//		});
//		Thread.sleep(5000);

		List<String> lst1 = List.of("a","b","c","d","ee","ff","gg");
		List<String> lst2 = List.of("z","x","y","v","uu","tt","ss");
		Flux<String> stringFlux = Flux.fromIterable(lst2);
		Flux<String> f2 = Flux.fromIterable(lst1).log();
//		f2.subscribe(System.out::println);
		// Modifies the data inside the flux
//		Flux<String> f3 = f2.map(String::toUpperCase);
//		f3.subscribe(System.out::println);
//		Flux<String> f4 = f2.filter(data -> data.length() > 1);
//		f4.subscribe(System.out::println);

//		Flux<String> f5 = f2.flatMap(data -> Flux.just(data.toUpperCase())).log();
//		f5.subscribe(System.out::println);


//		Function<Flux<String>, Flux<String>> fninterface1 = (data) -> data.map(String::toUpperCase);
//		Flux<String> f6 = f2.transform(fninterface1).log();
//		f6.subscribe(System.out::println);

		List<Integer> lst3 = List.of(1,2,3,4,5);
		Flux<Integer> f7 = Flux.fromIterable(lst3).log();
//		Function<Flux<Integer>, Flux<String>> fninterface2 = (data) -> data.map(Objects::toString);
//		Flux<String> f8 = f7.transform(fninterface2).log();
//		f8.subscribe(data -> {
//			System.out.println(data.getClass());
//		});

//		Flux<String> f9 = f2.filter(data -> data.length() > 9).defaultIfEmpty("we");
//		StepVerifier.create(f9).expectNextCount(1).verifyComplete();

//		Flux<String> stringFlux1 = f2.filter(data -> data.length() > 2).switchIfEmpty(stringFlux);

		// concat method is synchronous(concatWith also same)
//		Flux<String> concatflux = Flux.concat(f2.delayElements(Duration.ofSeconds(1)), stringFlux.delayElements(Duration.ofSeconds(2))).log();
//		StepVerifier.create(concatflux).expectNextCount(14);
//		concatflux.subscribe(System.out::println);

		// merge is asynchronous
//		Flux<String> mergeflux = Flux.merge(f2.delayElements(Duration.ofSeconds(1)), stringFlux.delayElements(Duration.ofSeconds(2))).log();
//		mergeflux.subscribe(System.out::println);
//		Thread.sleep(20000);

		// zip combines fluxes of different types and gives a flux of tuple2 type.
//		Flux<Tuple2<String, Integer>> zipflux = Flux.zip(f2, f7);
//		zipflux.subscribe(data -> {
//			System.out.println(data);
////			System.out.println(data.getClass());
//		});
		// But we can modify the result flux type by passing a function
//		Flux<String> zipFlux = Flux.zip(f2, f7, (first, second) -> {
//			return first + ":" + second;
//		});
//		zipFlux.subscribe(data -> {
////			System.out.println(data.getClass());
//			System.out.println(data);
//		});

		Flux<String> stringFlux1 = f2.doOnNext(data -> {
			System.out.println("on next "+data);
		}).doOnEach(data -> {
			System.out.println("on each "+data);
		}).doOnSubscribe(data -> {
			System.out.println("on subscribe");
		}).doOnComplete(() -> {
			System.out.println("on complete");
		});

		stringFlux1.subscribe(System.out::println);

	}

}
