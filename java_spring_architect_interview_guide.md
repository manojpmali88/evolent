## Java + Spring Architect Interview Guide (2025)

- Ultra-concise answers tailored for architect-level interviews
- Use this as a rapid revision sheet; expand any answer as needed during interviews

---

### LEVEL 1: BEGINNER (0-2 Years Experience)

#### Core Java Fundamentals

1. JDK vs JRE vs JVM
- JDK: Dev toolkit (compiler `javac`, tools, JRE).
- JRE: Runtime (JVM + std libs) to run Java apps.
- JVM: Engine that runs bytecode (platform-specific implementation).

2. Main features of Java (OOP principles)
- Encapsulation, Inheritance, Polymorphism, Abstraction; plus platform-independent (JVM), garbage collection, rich libraries, strong typing.

3. Primitive data types
- byte, short, int, long, float, double, char, boolean.

4. Autoboxing and unboxing
- Automatic conversion between primitives and wrapper types (e.g., `int` ↔ `Integer`).

5. Access modifiers
- private: within class.
- default (package-private): within package.
- protected: package + subclasses.
- public: everywhere.

6. Package
- Namespace for classes/interfaces; avoids name clashes; controls access; aligns with directory structure.

7. static keyword; static variables/methods
- static members belong to class (one per class). Static methods can’t access instance members directly; static blocks run once per class load.

8. Constructor; types
- Special method to initialize objects. Types: default (compiler-provided), no-arg, parameterized, copy. Not inherited; can be private.

9. Static methods in a constructor?
- You can CALL static methods inside a constructor; constructors themselves cannot be static.

#### OOP Concepts

10. Inheritance; types
- Acquire fields/methods from superclass. Types: single, multilevel, hierarchical. Java forbids multiple class inheritance; allows multiple interfaces.

11. Polymorphism; examples
- Compile-time (overloading): same name, different params. Runtime (overriding): subclass provides implementation. Example: `List.toString()` overridden in subclass; `println(obj)` calls correct method at runtime.

12. Encapsulation vs Abstraction
- Encapsulation: hide data via accessors/mutators and access control. Abstraction: expose essential behavior via interfaces/abstract classes, hide implementation.

13. Overloading vs Overriding
- Overloading: same class, same name, different parameter list. Overriding: subclass, same signature; must respect covariant return, access level not more restrictive.

14. Interface vs Abstract class
- Interface: contract/capability; multiple inheritance; no state (except constants), default/static methods allowed. Abstract class: shared state/partial impl; single inheritance; use when sharing code or invariants.

15. Marker Interface
- No methods; conveys metadata to runtime/tools (e.g., `Serializable`, `Cloneable`). Often replaced by annotations.

#### String Handling

16. String vs StringBuilder vs StringBuffer
- String: immutable. StringBuilder: mutable, not thread-safe (fast). StringBuffer: mutable, synchronized (slower).

17. String literal vs new operator
- Literal interned in String Pool; `new String("a")` creates a distinct heap object. `==` differs; `equals()` same by value.

18. String pool
- Interned unique string instances; `"abc"` and `String.intern()` reuse same object.

19. Advantages of String pool
- Reduced memory, faster equality checks, improved performance for common literals.

20. Why String immutable
- Security (classloaders, system properties), caching (hashCode), thread-safety, enables pooling.

#### Basic Collections

21. Collection in Java
- Framework for data structures/algorithms: `List`, `Set`, `Queue`, `Deque`; `Map` separate but related.

22. Array vs ArrayList
- Array: fixed size, can store primitives. ArrayList: resizable, objects only (unless autoboxed), convenient APIs.

23. ArrayList vs LinkedList
- ArrayList: O(1) random access; inserts/removals in middle O(n). LinkedList: O(1) add/remove at ends; poor cache locality; random access O(n).

24. HashMap; basic ops
- Key→value store. Ops: `put`, `get`, `remove`, `containsKey`, iterate `entrySet`. Allows one null key and many null values.

25. HashSet vs TreeSet
- HashSet: hash-based, no order, O(1) avg ops. TreeSet: sorted (natural/comparator), O(log n), no null in modern JDKs.

26. Iterator
- Cursor over collection with `hasNext()`, `next()`, optional `remove()`. Most are fail-fast.

27. List vs Set
- List: ordered, duplicates allowed. Set: no duplicates, order depends on implementation.

28. Array vs List
- Array: fixed, primitives allowed. List: dynamic, objects; richer API.

29. Set vs List
- Set: uniqueness guarantee; List: preserves order and allows duplicates.

#### Exception Handling

30. Exception; types
- Abnormal condition. Types: checked (`Exception` excluding `RuntimeException`), unchecked (`RuntimeException`), `Error` (serious JVM issues).

31. Checked vs unchecked
- Checked must be declared/handled; unchecked need not; indicate programming errors.

32. try-catch-finally
- Handle exceptions; `finally` executes regardless (except abrupt termination), good for cleanup.

33. try without catch
- Yes: `try` + `finally` or try-with-resources (`try (...) {}`) without explicit `catch`.

34. throw vs throws
- `throw`: actually raise an exception instance. `throws`: declare method may throw.

35. User-defined exceptions use cases
- Domain/business rule violations, validation, specific error semantics.

36. Handle user-defined exception
- Create class extending `Exception`/`RuntimeException`; `throw` where needed; `catch` or declare `throws`.

37. NullPointerException; prevention
- Dereferencing null. Prevent with validations, Optional, constructor invariants, annotations (`@NonNull`), avoiding `null` returns.

38. ClassCastException
- Invalid cast at runtime. Prevent with generics and `instanceof` checks.

39. Error vs Exception
- `Error` is unrecoverable (e.g., `OutOfMemoryError`), don’t catch generally. `Exception` is recoverable.

#### Basic Control Structures

40. break vs continue
- break: exit loop/switch. continue: skip to next iteration.

41. == vs .equals()
- `==`: primitives compare value, references compare identity. `equals()`: value equality per class contract.

#### Spring Boot Basics

42. Spring Boot
- Opinionated Spring; auto-configuration, embedded server, starters, actuator.

43. Advantages
- Minimal setup, convention-over-configuration, quick start, production-ready features.

44. @SpringBootApplication
- Meta: `@Configuration` + `@EnableAutoConfiguration` + `@ComponentScan`.

45. @Component vs @Service vs @Repository
- Stereotypes. `@Repository` adds exception translation. `@Service` for business semantics.

46. Dependency injection
- Container provides dependencies to objects (IoC), improves testability/decoupling.

47. @Autowired
- Injection annotation. Prefer constructor injection; optional with single-constructor beans since Spring 4.3.

48. Spring Boot starters
- Curated dependency BOMs (e.g., `spring-boot-starter-web`) + auto-config.

49. application.properties
- Externalized config; supports profiles (`application-<profile>.properties`).

50. Spring vs Spring Boot
- Spring is the ecosystem; Boot layers opinionated auto-config and tooling over it.

51. IoC container
- `ApplicationContext` managing bean creation, dependency wiring, lifecycle.

#### REST API Basics

52. HTTP; common methods
- GET, POST, PUT, PATCH, DELETE, HEAD, OPTIONS.

53. HTTP status codes
- 200 OK; 404 Not Found; 500 Internal Server Error (server fault).

54. REST API
- Resource-oriented, stateless, cacheable, uniform interface; representations (JSON/XML).

55. JSON
- Lightweight text format: objects (key:value), arrays; UTF-8.

56. @RestController vs @Controller
- `@RestController` = `@Controller` + `@ResponseBody` for JSON/XML. `@Controller` returns views/templates.

57. Process of creating a REST API (example)
- Define domain (Entity/DTO) → repository/service → controller mappings (`@GetMapping`, `@PostMapping`) → validate (`@Valid`) → test with MockMvc/Postman.

---

### LEVEL 2: INTERMEDIATE (2-4 Years Experience)

#### Collections Deep Dive

58. hashCode()/equals() contract
- Equal objects MUST have equal hashCodes; consistent within execution; unequal may collide.

59. HashMap internals
- Array of buckets; hash → index; buckets hold nodes or red-black trees (after threshold). Resize at `capacity * loadFactor`.

60. HashMap collision
- Bucket chains (linked list → tree if many). `equals()` differentiates keys.

61. Load factor
- Density threshold triggering resize; default 0.75 balances memory/perf.

62. HashMap vs LinkedHashMap vs TreeMap
- HashMap: unordered. LinkedHashMap: insertion-order (or access-order). TreeMap: sorted by key.

63. HashMap vs LinkedHashMap vs ConcurrentHashMap
- ConcurrentHashMap supports concurrent access (CAS/striped locks), no null keys/values.

64. Convert HashMap to ArrayList
- `new ArrayList<>(map.entrySet())` or `new ArrayList<>(map.keySet())` / `values()`.

65. Comparable vs Comparator
- `Comparable.compareTo` (natural order, in class). `Comparator.compare` (external strategy; multiple orders).

66. ConcurrentHashMap; how it works
- Bucket-level synchronization; CAS; tree bins; weakly consistent iterators.

67. Hashtable vs ConcurrentHashMap
- Hashtable: legacy, global lock. CHM: finer-grained, better performance, no nulls.

68. Vector vs ArrayList
- Vector: synchronized legacy. ArrayList: unsynchronized; prefer with external sync if needed.

69. HashMap vs Hashtable
- As above; plus null support: HashMap allows one null key/many null values; Hashtable none.

70. ArrayList vs LinkedList
- Already covered (random access vs fast deque ops).

#### Java 8 Features

71. Functional Interface
- Exactly one abstract method; `@FunctionalInterface`. Examples: `Runnable`, `Callable`, `Comparator`.

72. Java 8 highlights
- Lambdas, method refs, Streams, Optional, default/static methods, new Date/Time API, CompletableFuture.

73. map() vs flatMap()
- map: 1→1 transformation. flatMap: 1→many then flattens.

74. Stream API advantages
- Declarative, lazy, parallelizable, composable pipelines; fewer side-effects.

75. Stream pipeline
- Source → intermediate ops (lazy) → terminal op (triggers execution).

76. Intermediate vs terminal ops
- Intermediate: `map`, `filter`, `sorted`, `distinct`, `peek`. Terminal: `collect`, `reduce`, `forEach`, `count`, `anyMatch`.

77. 2nd highest salary (Stream)
- `employees.stream().map(Employee::getSalary).distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst()`.

78. Use of Streams in projects
- ETL, in-memory aggregations, filter-map-reduce, building immutable views.

79. Lambda vs Anonymous class
- Lambdas: concise, capture effectively-final vars, for functional interfaces. Anonymous classes: verbose; can implement multiple methods (via class) but not functional.

#### Advanced OOP

80. Functional Interface
- Same as 71.

81. Sealed Classes (Java 17)
- Restrict which classes can extend/implement; `permits` list; enables exhaustive pattern matching.

82. Fail-Fast iteration; handle it
- Detects concurrent structural modification and throws `ConcurrentModificationException`. Handle via concurrent collections, snapshot iterators, or no in-loop mutation except via iterator.

83. ConcurrentModificationException; fail-safe vs fail-fast
- Fail-fast: most collections. Fail-safe: concurrent collections iterate over snapshot (no CME).

84. final, finally, finalize()
- final: non-changeable (var), non-overridable (method), non-inheritable (class). finally: cleanup block. finalize(): deprecated, unreliable.

85. Autoboxing vs Unboxing
- Same as 4.

86. Cloneable; deep vs shallow clone
- `Cloneable` marks class for `Object.clone()`; default is shallow; deep requires manual copying of nested objects.

87. Shallow vs Deep Copy
- Shallow copies references; deep recursively copies object graph.

#### Memory Management

88. Java memory management
- Objects on heap, references on stack; GC reclaims unreachable; escape analysis may allocate on stack.

89. Garbage collection; types
- G1 (default), ZGC, Shenandoah (low-latency), Parallel GC. Choose based on latency vs throughput.

90. finalize()
- Last-resort cleanup; deprecated; use try-with-resources/cleaners.

91. Stack vs Heap
- Stack: per-thread frames, method calls, primitives/refs. Heap: shared objects.

92. Handle OutOfMemoryError
- Increase heap, fix leaks, reduce object churn, tune GC, analyze heap dumps (MAT), use streaming/iterative processing.

#### Multithreading Basics

93. Multithreading; lifecycle
- States: NEW → RUNNABLE → RUNNING → BLOCKED/WAITING/TIMED_WAITING → TERMINATED.

94. Synchronization; synchronized
- Mutual exclusion via intrinsic monitor; guarantees visibility and atomicity for blocks.

95. wait() vs sleep()
- wait: releases monitor, used with notify/notifyAll. sleep: does not release monitor, pauses thread.

96. volatile
- Visibility + ordering (happens-before) for single variable; not atomic for compound ops.

97. ThreadLocal
- Per-thread variable storage; avoid for request-scoped in thread pools (clean up!)

98. Deadlock; avoidance
- Cyclic lock dependency. Avoid with lock ordering, timeouts, tryLock, minimizing shared state.

99. Thread vs Runnable
- Thread encapsulates OS thread + task; Runnable is task interface.

100. Runnable vs Callable
- Callable returns value and throws checked exceptions; works with Future.

101. Synchronized methods vs blocks
- Methods lock on `this`/class; blocks allow custom lock objects and smaller scope.

#### Spring Boot Intermediate

102. Auto-configuration
- Conditional beans based on classpath/properties (`@ConditionalOnClass`, `@ConditionalOnProperty`).

103. @Configuration and @Bean
- Java-based config; `@Configuration` classes are proxied to ensure singleton semantics; `@Bean` methods create beans.

104. Profiles
- `@Profile("dev")` for env-specific beans; activate via `spring.profiles.active`.

105. @Transactional; benefits
- Declarative transactions; atomicity, rollback on exceptions; boundary management.

106. Global exception handler
- `@ControllerAdvice` + `@ExceptionHandler` methods return consistent API errors.

107. properties vs yml
- Same semantics; YAML is hierarchical and concise.

108. CommandLineRunner vs ApplicationRunner
- Both run after context; `ApplicationRunner` gives parsed `ApplicationArguments`.

109. Embedded server (Tomcat)
- Auto-started with web starter; embedded container serves on configured port.

110. Override auto-config
- Define your own bean of same type, exclude auto-config classes, or set properties.

111. Circular dependencies
- Prefer constructor injection (detects early). Break cycles via redesign, interfaces, events, `@Lazy`.

#### Dependency Injection

112. Constructor vs field vs setter
- Prefer constructor (immutability/testability). Setter for optional deps. Avoid field injection.

113. @Qualifier and @Primary
- `@Primary` sets default bean; `@Qualifier` selects by name at injection site.

114. Precedence: @Qualifier vs @Primary
- `@Qualifier` at injection point overrides `@Primary`.

115. Avoid bean creation failures
- Constructor injection, `@Lazy`, proper scanning, `@Conditional*`, correct package structure, avoid static state.

116. @Autowired vs @Qualifier
- `@Autowired` injects; `@Qualifier` disambiguates which bean to inject.

117. @Primary vs @Qualifier
- `@Primary` default choice; `@Qualifier` explicit choice.

#### REST API Advanced

118. @RequestMapping vs @GetMapping
- `@GetMapping` is a composed shortcut of `@RequestMapping(method=GET)`.

119. @PathVariable vs @RequestParam
- PathVariable: part of URI path. RequestParam: query string or form params.

120. @PostMapping vs @PutMapping
- POST: create/non-idempotent. PUT: replace/idempotent.

121. PUT vs PATCH
- PUT replaces full resource; PATCH applies partial updates.

122. @ExceptionHandler vs @ControllerAdvice
- Method-level handler vs global cross-controller advice.

#### Spring Boot Annotations

123. @ComponentScan vs @EnableAutoConfiguration
- ComponentScan: finds your beans. EnableAutoConfiguration: imports Boot’s auto-configs.

124. @Configuration vs @Bean
- Class vs factory method.

125. @Async vs @Scheduled
- Async executes in separate thread pool. Scheduled runs on cron/fixed intervals.

126. @Cacheable vs @CacheEvict
- Cacheable stores/returns cached results; Evict removes entries.

#### Database & JPA Basics

127. ORM
- Maps objects to relational tables; reduces impedance mismatch.

128. JPA vs Hibernate
- JPA is spec/API; Hibernate is implementation (plus extensions).

129. Entity
- Persistent class annotated with `@Entity` mapped to table.

130. Core JPA annotations
- `@Entity`, `@Id`, `@GeneratedValue`, `@Table`, relationship annotations.

131. persist() vs merge()
- `persist`: make new entity managed; no return; insert. `merge`: copy state into managed instance; returns managed instance; for detached.

132. Relationships
- `@OneToMany`, `@ManyToOne`, `@OneToOne`, `@ManyToMany`; maintain owning side; set `mappedBy`.

133. JPQL
- SQL-like over entities/properties; database-agnostic.

134. Lazy vs eager loading
- LAZY: fetch on access; EAGER: fetch immediately; prefer LAZY to avoid N+1.

135. save() vs saveAndFlush()
- `save` schedules; `saveAndFlush` synchronizes with DB immediately (flush).

136. Hibernate get() vs load()
- get: hits DB now; returns null if missing. load: returns proxy; exception on access if missing.

#### Testing Basics

137. JUnit; basic annotations
- `@Test`, `@BeforeEach`, `@AfterEach`, `@BeforeAll`, `@AfterAll`, `@Disabled`.

138. Mockito; @Mock usage
- Create test doubles; `when(...).thenReturn(...)`.

139. @Mock vs @MockBean vs @Spy
- @Mock: pure Mockito mock. @Spy: partial mock. @MockBean: Spring Boot creates mock in application context.

140. Test REST with MockMvc
- `@WebMvcTest` + `MockMvc.perform(...)` + `andExpect(...)` assertions.

141. @SpringBootTest vs @WebMvcTest
- SpringBootTest: full context (slow). WebMvcTest: MVC slice (fast, controllers only).

#### Security Basics

142. Authentication vs Authorization
- Authentication: who you are. Authorization: what you can do.

143. Spring Security
- Configurable filter chain for authn/z; supports multiple protocols.

144. Securing REST APIs
- Stateless sessions, JWT/OAuth2 resource server, HTTPS, CORS, disable CSRF for stateless APIs, least privilege.

145. OAuth vs JWT
- OAuth2: authorization framework/protocols. JWT: token format; can carry claims; used by OAuth2.

146. Common status codes
- 401 Unauthorized, 403 Forbidden, 404 Not Found, 500 Internal Server Error, 502 Bad Gateway, 503 Service Unavailable.

---

### LEVEL 3: ADVANCED (4+ Years Experience)

#### JVM Internals & Performance

147. JVM internals
- Class loading (parent delegation), runtime data areas (heap, stacks, metaspace), JIT, GC cycles.

148. Class loaders
- Bootstrap → Platform/Extension → Application; custom loaders for plugins/isolation.

149. Reference types
- Strong (default), Soft (cache, GC under memory pressure), Weak (GC at next cycle if only weak refs), Phantom (post-mortem cleanup).

150. Memory leaks despite GC
- Unintentional strong references (static caches, collections, listeners); thread-locals; classloader leaks.

151. GC algorithms
- G1 (balanced), ZGC/Shenandoah (low-latency), Parallel (throughput). Choose per latency/throughput SLA.

152. Tuning JVM
- Size young/old, choose GC, set pause targets, profile allocations, remove hotspots, use CDS/AOT where applicable.

153. JIT compilation
- Hot code compiled to native; tiered compilation (C1/C2); profiling guides optimization.

154. JVM memory areas
- Heap, Thread stacks, Metaspace (class metadata), PC register, Native method stack, Code cache.

155. Metaspace (Java 8+)
- Native memory for class metadata; grows until limit; tune with `-XX:MaxMetaspaceSize`.

156. Analyze heap/thread dumps
- Tools: jcmd, jmap, jstack, JFR, VisualVM, JMC, Eclipse MAT; look for dominators, leak suspects, blocked threads.

#### Advanced Concurrency

157. Executor framework
- `ExecutorService`, `Executors`, `ForkJoinPool`; decouple submission from execution.

158. Future
- Handle to async result; `get()` blocks; cancelable.

159. ThreadPool
- Reuse threads; bounded queues; tune sizes by workload (CPU vs IO bound).

160. ReentrantLock vs synchronized
- ReentrantLock: tryLock/timeouts/fairness/Conditions; synchronized is simpler, auto-released.

161. volatile vs synchronized
- volatile: visibility/ordering. synchronized: mutual exclusion + visibility across critical sections.

162. Thread safety vs atomicity
- Safety: correct behavior in concurrency. Atomicity: indivisible operations.

163. CountDownLatch vs CyclicBarrier
- Latch: one-shot gate. Barrier: reusable rendezvous.

164. Busy-waiting vs blocking vs non-blocking
- Busy-wait: spins; blocking: thread suspended; non-blocking: progress without locks (CAS).

165. CompletableFuture internals
- DAG of stages, work-stealing via ForkJoinPool, async chaining, completion queues.

166. Avoid thread starvation
- Use dedicated pools, avoid blocking on commonPool, back-pressure, correct pool sizing.

167. Thread-safe singleton
- Enum singleton; or double-checked locking with volatile.

168. Producer-Consumer with BlockingQueue
- Shared `BlockingQueue`; producer `put`, consumer `take`; naturally throttles.

169. ForkJoinPool vs regular pools
- Work-stealing for fine-grained tasks (divide-and-conquer). Regular pools for general workloads.

170. Parallel vs sequential streams
- Parallel uses ForkJoin; best for CPU-bound, large data, low contention; avoid blocking ops.

171. Live-lock vs deadlock
- Live-lock: active but no progress (threads change state). Deadlock: mutual waiting.

172. Java Memory Model (JMM)
- Defines visibility/ordering; happens-before rules; volatile and locks establish HB edges.

173. Semaphore
- Controls permits to access limited resources; e.g., DB connections.

174. BlockingQueue
- Thread-safe queues; types: ArrayBlockingQueue, LinkedBlockingQueue, PriorityBlockingQueue, DelayQueue, SynchronousQueue.

#### Advanced Spring Boot

175. Bean lifecycle; hooks
- Instantiate → populate → `BeanPostProcessor` → `@PostConstruct`/`InitializingBean.afterPropertiesSet` → ready → destroy (`@PreDestroy`, `DisposableBean`).

176. Proxies in Spring; JDK vs CGLIB
- JDK proxies for interfaces; CGLIB for classes; used for AOP/transactions.

177. @Autowired vs @Inject vs @Resource
- Autowired (Spring), Inject (JSR-330), Resource (JSR-250 by name). Prefer constructor injection.

178. Inject prototype into singleton
- Use `ObjectFactory`/`Provider`, method injection (`@Lookup`), or proxy-scoped beans.

179. Default bean scope
- Singleton.

180. Custom auto-configuration
- Create `@AutoConfiguration` (Boot 3) and register via `spring.factories`/`META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports`.

181. Spring Boot Actuator; endpoints
- Health, Info, Metrics, Env, Thread dump, Heap dump, Mappings; secure and expose selectively.

182. Custom health checks
- Implement `HealthIndicator` or `ReactiveHealthContributor`.

183. Conditional annotations
- `@ConditionalOnProperty`, `@ConditionalOnClass`, `@ConditionalOnMissingBean`, etc.

184. Custom metrics/monitoring
- Micrometer + `MeterRegistry` (Prometheus); counters, timers, gauges, distribution summaries.

185. Bean scopes
- singleton, prototype, request, session, application, websocket.

186. Prototype vs Request scope
- Prototype: new bean per injection/use. Request: new bean per HTTP request.

#### Advanced AOP

187. AOP in Spring Boot
- Proxy-based interception of join points to apply cross-cutting concerns.

188. Advice types
- @Before, @After, @AfterReturning, @AfterThrowing, @Around.

189. Pointcut
- Expression selecting join points (`execution(* com..Service.*(..))`).

190. JoinPoint
- Context (method signature, args, target, proxy).

191. Custom annotations + AOP
- Define annotation, pointcut on annotation, implement advice reading annotation attributes.

192. Real-world uses
- Logging, auditing, security checks, caching, metrics, transactions.

#### Advanced JPA & Database

193. N+1 selects
- Lazy collections cause repeated queries. Fix with fetch joins, entity graphs, batch fetching, DTO projections.

194. Entity graphs
- Declarative fetch plans (`@NamedEntityGraph`); avoid N+1; per-query selection.

195. @Query vs derived vs Criteria
- Derived for simple cases; @Query for complex; Criteria for dynamic type-safe queries.

196. Optimistic locking; @Version
- Detect concurrent updates via version check; throw `OptimisticLockException` on conflict.

197. Pessimistic locking
- DB locks (`PESSIMISTIC_READ/WRITE`); use under high contention or critical consistency.

198. Pagination/sorting
- `Pageable`, `Page`, `Slice`, `Sort`; limit result set efficiently.

199. Transactions; ACID
- Atomicity, Consistency, Isolation, Durability; choose isolation level per use-case.

200. Connection pooling; HikariCP
- Reuse connections; tune pool size, timeout, leak detection; Hikari is default and fast.

201. DB migrations
- Flyway/Liquibase versioned scripts; CI/CD integration; zero-downtime strategies.

202. Indexing; optimization
- Proper indexes on predicates/joins; avoid over-indexing; analyze with EXPLAIN; consider covering indexes.

#### Advanced Spring Security

203. OAuth2 and JWT
- Use Spring Authorization Server or external IdP; resource servers validate JWTs; scopes/claims drive access.

204. Stateless session; JWT
- No server sessions; JWT carries claims; validate signature/expiry; rotate keys.

205. 2FA
- TOTP (RFC 6238), WebAuthn, SMS/Email backup; store secrets securely; step-up auth flows.

206. CSRF protection
- Required for stateful browser sessions. Disable for stateless APIs; otherwise use synchronizer tokens or SameSite cookies.

207. Pre-auth vs post-auth filters
- Filters before authentication (e.g., CORS, CSRF) vs after (authorization, auditing).

208. SecurityFilterChain (Spring Boot 3+)
- Configure via bean DSL; define matcher → authorize → oauth2/jwt → csrf/session.

209. UserDetailsService
- Loads user by username; backends: DB/LDAP; integrate with PasswordEncoder.

210. RBAC
- Roles/authorities mapped to endpoints/methods; enforce with annotations and URL rules.

211. Method-level security
- `@PreAuthorize`, `@PostAuthorize`, `@Secured`, `@RolesAllowed`.

212. Secure microservices comms
- mTLS, OAuth2 machine-to-machine, API gateways, service mesh policies.

213. OAuth in Spring Boot
- `spring-boot-starter-oauth2-client`/`-resource-server`; configure issuer, jwk-set, clients.

#### Microservices Architecture

214. Monolith vs microservices
- Monolith: simple, one deploy; harder to scale/maintain at size. Microservices: independent deploys/scaling; complexity in ops, data consistency.

215. Service communication
- Sync (REST/gRPC), async (Kafka/RabbitMQ); choose per coupling/latency needs.

216. RestTemplate
- Legacy blocking HTTP client; prefer `WebClient` (reactive) in new apps.

217. API Gateway
- Central ingress: routing, auth, rate limiting, aggregation, TLS termination.

218. Service discovery
- Registry (Eureka, Consul); clients/gateway resolve service instances.

219. Resilience patterns
- Retry, Circuit Breaker, Bulkhead, Timeout, Fallback, Rate limit; use Resilience4j.

220. Circuit Breaker
- Opens on failures to prevent cascading; half-open probes; libraries: Resilience4j.

221. API rate limiting
- Token bucket/leaky bucket; gateway filters (Kong, Spring Cloud Gateway), Redis-based counters.

222. Slow service isolation
- Timeouts, bulkheads, circuit breakers, hedging requests, queue backpressure.

223. API versioning
- URI (`/v1`), header, content negotiation; sunset policies.

224. Distributed logging/tracing
- Correlation IDs; OpenTelemetry/Zipkin/Jaeger; centralized logs (ELK).

225. Sync vs async
- Sync: request/response, simpler, tighter coupling. Async: event-driven, decoupled, eventual consistency.

226. Eventual consistency; CAP
- Trade consistency/availability under partition; use outbox, idempotency, retries.

227. Saga pattern
- Orchestration (central coordinator) or choreography (events) to manage distributed transactions.

228. Data consistency across services
- Outbox + CDC, idempotent consumers, versioning, compensation actions.

229. Microservices vs Monolith
- See 214; pick based on team/org maturity and domain boundaries.

230. Producer vs Consumer apps
- Producer publishes messages to topics; Consumer subscribes and processes.

#### Apache Kafka

231. Core components
- Brokers, Topics, Partitions, Producers, Consumers, ZooKeeper/KRaft controller, Schema Registry (optional).

232. Partition
- Unit of parallelism and ordering; key-based routing determines partition.

233. Topic/Producer/Consumer
- Topic: named log. Producer: writes records. Consumer: reads records.

234. Consumer Groups; rebalancing
- Group shares a topic; each partition consumed by one member; rebalancing on membership/partition changes.

235. Endless retries
- Use DLQ after max attempts; backoff; poison-pill handling.

236. Message ordering
- Guaranteed per partition; use consistent key; single partition if strict total ordering needed (limits throughput).

237. Kafka Connect
- Pluggable connectors for source/sink integration; ETL without custom code.

238. Exactly-once semantics
- Idempotent producers + transactions + EOS consumer; careful configuration.

239. Kafka Streams
- Library for stateful stream processing; windowing, joins, exactly-once; alternative: ksqlDB, Flink.

240. Monitoring Kafka
- JMX metrics, lag monitoring, Cruise Control, Burrow; alert on lag, ISR, under-replicated partitions.

241. Kafka real-time processing
- Append-only commit log; consumers process in near real-time; scaling via partitions.

#### Advanced Testing

242. Unit vs Integration vs E2E
- Unit: isolate class. Integration: multiple components + infra. E2E: full system via external interfaces.

243. Mock external REST APIs
- WireMock, MockWebServer, MockRestServiceServer for RestTemplate/WebClient.

244. TestContainers
- Run real infra (DB/Kafka) in Docker during tests for reproducibility.

245. Parameterized tests (JUnit 5)
- `@ParameterizedTest` + sources (`@ValueSource`, `@MethodSource`, `@CsvSource`).

246. @WebMvcTest vs @SpringBootTest
- See 141.

247. Builders and Object Mothers
- Patterns to create test data reliably; avoid fragile fixture duplication.

248. Acceptance testing framework
- Cucumber/RestAssured/Karate for BDD/API acceptance tests.

---

### EXPERT LEVEL (5+ Years / Architect)

#### System Design & Architecture

251. Scalable e-commerce design
- Domain-driven boundaries (catalog, cart, orders, payments, inventory). API Gateway, CQRS for reads, event-driven inventory, search (Elastic), cache (Redis), async order workflow (Saga), DB sharding/replication, CDN, observability.

252. Distributed caching
- Redis/Hazelcast for hot reads, session tokens, rate limits; choose topology (replicated/partitioned); set TTL/eviction; warm-up strategies.

253. CQRS
- Separate read/write models; use when read patterns differ, scaling reads, or projections; adds complexity and eventual consistency.

254. Event sourcing
- Store events as source of truth; rebuild state via replay; auditability; higher complexity.

255. Database sharding
- Split data horizontally (hash/range/geo); handle rebalancing, cross-shard queries, global IDs.

256. High availability
- Redundancy across zones/regions, health checks, failover, quorum, chaos testing.

257. Load balancing
- L4 (NLB), L7 (ALB/Envoy/Nginx). Strategies: round-robin, least-connections, consistent hashing.

258. API Gateway patterns
- Edge auth, routing, rate limiting, aggregation, circuit breaking, canary releases.

259. Strangler fig pattern
- Incrementally route portions of traffic from monolith to new microservices via gateway.

260. Monitoring/alerting
- Metrics (RED/USE), logs, traces; SLOs/SLIs; on-call runbooks; anomaly detection.

261. Redis caching; when to use
- Hot reads, leaderboards, sessions, distributed locks; avoid caching highly volatile or tiny datasets.

#### DevOps & Cloud

262. Dockerizing Spring Boot
- Multi-stage Dockerfile (build JAR then run with distroless/temurin JRE), minimal layers, healthcheck.

263. Docker Compose; multi-stage builds
- Compose orchestrates local deps (DB, Kafka). Multi-stage reduces image size and attack surface.

264. Jenkins pipeline
- Stages: checkout → build/test → static analysis → image build → security scan → deploy → smoke tests.

265. Blue-green vs rolling
- Blue-green: two prod envs, instant switch. Rolling: gradual replace; less capacity buffer needed.

266. Zero-downtime deploy
- Rolling/canary, health probes, DB migrations backward-compatible, session stickiness.

267. IaC; Terraform basics
- Manage infra declaratively; modules, state, plan/apply; versioned in VCS.

268. Secrets management
- Vault/KMS/SSM/Secrets Manager; avoid env vars for highly sensitive secrets; rotate regularly.

269. Observability stack
- Prometheus + Grafana, Loki/ELK, OpenTelemetry traces; SLO dashboards.

270. JAR vs WAR
- JAR (fat jar with embedded server) vs WAR (deploy to external container). Boot prefers JAR.

271. Maven vs Gradle
- Maven: convention, XML, stable. Gradle: Groovy/Kotlin DSL, faster incremental builds.

272. CI vs CD
- CI: integrate and test changes frequently. CD: auto deployment to prod after passing checks.

#### Kubernetes & Cloud Native

273. Kubernetes basics
- Pods (containers), Services (stable networking), Deployments (replicas/rollouts), ConfigMaps/Secrets, Ingress.

274. Deploy Spring Boot on K8s
- Containerize, manifests/Helm charts, probes, resource requests/limits, config via env/ConfigMap/Secrets.

275. Sidecar container
- Auxiliary container for logging, proxy (Envoy), adapters (Istio), agents.

276. Config in K8s
- ConfigMaps for non-secret config; Secrets for credentials; mount as env/volumes.

277. Service mesh (Istio)
- mTLS, traffic shaping, retries, telemetry, policy via sidecars and control plane.

278. Autoscaling
- HPA (CPU/memory/custom metrics); VPA, cluster autoscaler.

279. Ingress controller
- Layer 7 routing into cluster (Nginx, Traefik, Istio Gateway).

280. Health checks
- Readiness/Liveness probes; startup probes for long init.

281. Helm
- Package manager for K8s; charts/values; versioned releases and rollbacks.

282. Cloud-native patterns
- 12-factor app, externalized config, stateless processes, disposability, health endpoints, telemetry, backpressure.

#### Performance & Troubleshooting

283. Profiling Java apps
- JFR/JMC, async-profiler, VisualVM; measure CPU, memory, locks, allocations.

284. Debug memory leaks
- Heap dumps + MAT dominator tree; look for growth patterns; fix lingering references.

285. Analyze thread dumps
- jstack/JMC; detect deadlocks, blocked threads, hotspots.

286. 504 vs 503 troubleshooting
- 504 Gateway Timeout: upstream slow/unreachable. 503 Service Unavailable: service overloaded/down; check readiness and autoscaling.

287. Optimize DB queries
- Proper indexes, avoid N+1, pagination, rewrite predicates, caching, connection pool tuning.

288. High CPU in prod
- Profile, check GC thrash, hot loops, lock contention, escalated QPS; mitigate via caching/pool sizing.

289. Monitoring tools
- Prometheus/Grafana, ELK/Loki, OpenTelemetry, Datadog/New Relic, Sentry.

290. Distributed tracing
- Propagate trace context; instrument via Micrometer/OTel; analyze latency per span.

291. Service Not Found
- DNS/registry issues, gateway routes, network policies; verify health, service names, ports.

292. Debug locally & remotely
- Dev containers, Skaffold/Telepresence, remote debug ports, feature flags, prod-like test envs.

---

### MODERN JAVA FEATURES (2024-2025)

#### Java 21+

293. Virtual vs Platform Threads
- Platform: OS-backed. Virtual: user-mode (Project Loom), lightweight, scheduled by JVM.

294. Virtual Threads for I/O-heavy apps
- Enable massive concurrency with blocking-style code; high throughput with minimal thread overhead.

295. When NOT to use Virtual Threads
- CPU-bound tasks, thread-local heavy code, synchronized bottlenecks, high native blocking calls.

296. Create Virtual Threads
- `try (var e = Executors.newVirtualThreadPerTaskExecutor()) { e.submit(task); }`

297. Record Patterns & switch
- Pattern matching deconstructs records directly in `switch`/`instanceof`, reducing boilerplate.

298. Pattern matching for instanceof
- `if (x instanceof String s) { ... }` binds variable on success; safer, cleaner.

299. getFirst()/getLast() in collections
- New convenience methods on `List`/`Deque` to access ends without magic indices.

300. String Templates
- Safer interpolation with processors; avoids brittle concatenation; supports validation/formatting.

#### Reactive Programming

301. Reactive programming
- Non-blocking, backpressured streams of data; event-driven pipelines.

302. Mono vs Flux (Project Reactor)
- Mono: 0..1 elements. Flux: 0..N elements.

303. Backpressure handling
- Reactive Streams protocol; strategies: buffer, drop, latest, error; control demand via `request(n)`.

304. Reactive vs Spring MVC
- Reactive (WebFlux) for high-concurrency I/O-bound services; MVC for simpler, blocking stacks or heavy CPU work.

305. Chain async ops with CompletableFuture
- `thenApply`, `thenCompose`, `allOf`, `anyOf`, `handle`, supply async executors.

306. Reactive vs Imperative
- Reactive: async, non-blocking, declarative flows. Imperative: straightforward, blocking; simpler to reason in low-concurrency contexts.

---

### SCENARIO-BASED QUESTIONS

#### Performance Issues

307. Slow startup in prod (45s) vs local (5s)
- Compare profiles/config; remote dependencies (DB/auth) timeouts; DNS/SSL; classpath scanning (fat JARs), entity scanning; logging sync IO; JVM flags; cold container start; measure with JFR.

308. REST APIs respond in 5s+
- Trace end-to-end; identify slow dependencies (DB, downstream), N+1 queries, thread pool saturation, GC pauses; add timeouts/bulkheads; cache hot paths; optimize indexes.

309. OOME at 1000 users
- Heap sizing vs leak; analyze heap, reduce object churn, stream processing, paginate, cache eviction, tune pool sizes, limit request size/concurrency.

310. Occasional 503 at peak
- Overload or dependency failure; add autoscaling, circuit breakers, queue buffering, rate limits, warm replicas, tune connection pools.

#### Security Scenarios

311. Users logged out every 30 minutes though JWT 24h
- Using session-based auth or short-lived refresh? Check clock skew, token renewal, gateway overriding TTL, cookie expiry, key rotation, audience mismatch.

312. Rate limiting at 10k rps from one IP
- Token bucket at gateway/WAF, per-API and per-tenant quotas, sliding window counters in Redis, ban malicious IPs, backpressure.

313. Implement SSO for 20 apps
- Central IdP (OIDC/OAuth2/SAML), federation, centralized login, app as clients, standard scopes/claims, shared gateway.

#### Database Issues

314. Catalog loads in 30s (10k products)
- Paging + caching, read replicas, denormalized search index (Elastic), proper indexes, avoid heavy joins; CDN for media.

315. LazyInitializationException in prod not in tests
- Accessing LAZY outside transaction; fix with fetch joins/DTOs, OpenSessionInView (last resort), service-layer boundaries.

316. Concurrent product update
- Optimistic locking with `@Version` and retry; or pessimistic locks for high contention.

#### Microservices Challenges

317. Monolith → microservices (2M users)
- Strangler pattern; carve by domain; shared contracts; event bus; observability; CI/CD; data decomposition; incremental rollout.

318. Prevent cascade failures (A→B→C; C down)
- Timeouts, retries with jitter, circuit breakers, bulkheads, fallbacks, cache, graceful degradation.

319. Order touches 5 services; one fails late
- Saga with compensating actions; idempotent operations; outbox + transactional messaging.

---

### BEHAVIORAL & LEADERSHIP

#### Technical Leadership

320. Evaluating new technologies
- Define business goals; run ADRs; small spikes/POCs; cost/risk analysis; roll out behind flags; measure outcomes.

321. Managing technical debt
- Maintain debt register; prioritize by impact; bake into sprint capacity (e.g., 15%); refactor opportunistically; enforce quality gates.

322. Handling design disagreements
- Align on requirements/constraints; enumerate options/trade-offs; data-driven spikes; decide via RFC/ADR; commit as a team.

323. Mentoring juniors
- Pairing, code reviews, learning paths, clear goals; celebrate wins; provide safe feedback loops.

#### Problem Solving

324. Complex problem solved
- Structure with 5 steps: define, measure, analyze, improve, control; use tracing/profiling; validate fix with canary + SLOs.

325. Technical decisions → business metrics
- Tie decisions to latency, error rate, conversion, infra cost; set KPIs and review post-implementation.

326. Prevented major prod issue
- Emphasize proactive alerts, chaos tests, capacity planning, and guardrails (circuit breakers, quotas).

327. Prioritize tech improvements vs features
- Balance via cost-of-delay, risk reduction, regulatory needs; allocate capacity; align roadmap with OKRs.

#### Communication & Collaboration

328. Explain tech to non-technical
- Use analogies, visuals, outcomes (SLOs, cost), avoid jargon; focus on risks/benefits.

329. Difficult team member
- Clarify expectations, active listening, agree on working agreements; involve mediator if needed; focus on outcomes.

330. Handling pressure & tight deadlines (Architect)
- Protect critical path: define MVP scope; de-risk unknowns early; add feature toggles; parallelize work streams; maintain SLOs; daily checkpoints; negotiate trade-offs transparently; ensure rollback plans.

---

Notes
- Some items appeared duplicated or with typos; they’re addressed in nearest related entries above.
- For deep dives, expand these bullets with code samples, diagrams, and runbooks as needed.