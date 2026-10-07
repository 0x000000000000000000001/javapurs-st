# purescript-st

## JVM tests

`./bin/test` selects `st` in the [common isolated runner](../javapurs/docs/testing.md#port-particulier), preserving this checkout and its outputs.
Use `./bin/test --help` for options and `./bin/test --clean` to rebuild the backend. The linked guide covers prerequisites, Java target/runtime settings and retained failure logs.

[![Latest release](http://img.shields.io/github/release/purescript/purescript-st.svg)](https://github.com/purescript/purescript-st/releases)
[![Build status](https://github.com/purescript/purescript-st/workflows/CI/badge.svg?branch=master)](https://github.com/purescript/purescript-st/actions?query=workflow%3ACI+branch%3Amaster)
[![Pursuit](https://pursuit.purescript.org/packages/purescript-st/badge)](https://pursuit.purescript.org/packages/purescript-st)

The ST effect, for safe local mutation.

## Installation

```
spago install st
```

## Documentation

Module documentation is [published on Pursuit](http://pursuit.purescript.org/packages/purescript-st).
