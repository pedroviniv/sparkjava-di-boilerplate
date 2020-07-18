# sparkjava-di-boilerplate
Sparkjava with dependency injection boilerplate to build REST APIs

it comes with:

- product create/list features
- separation of resources in different paths
- specific path for v1
- dependency injection with spring-context
- json response transformers
- simple security filter that just checks if a given `Bearer ${token}` was provided
- simple cors filter that allow any origin
- separation of application and core
