# Intro to Context

## Brief

Read the information in intro_to_context.md and answer the following questions:

1. Can an arrow function expression's context change?

No.

2. How do we know what object `this` refers to in an arrow function expression body?

In an arrow function expression body `this` always refers to the context in
which the function is defined.

3. Can a `function` expression's context change?

Yes - a `function` expression has execution context, which means `this` refers
to the context in which the function is executed

4. How do we know what object `this` refers to in a `function` expression body?

`this` refers to the object the function is executed by.
