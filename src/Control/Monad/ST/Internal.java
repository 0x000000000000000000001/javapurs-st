    public static Object map_ = (java.util.function.Function<Object, Object>) (f) ->
        (java.util.function.Function<Object, Object>) (a) ->
        (java.util.function.Supplier<Object>) () -> ((java.util.function.Function<Object, Object>) f).apply(((java.util.function.Supplier<Object>) a).get());

    public static Object pure_ = (java.util.function.Function<Object, Object>) (a) ->
        (java.util.function.Supplier<Object>) () -> a;

    public static Object bind_ = (java.util.function.Function<Object, Object>) (a) ->
        (java.util.function.Function<Object, Object>) (f) ->
        (java.util.function.Supplier<Object>) () -> ((java.util.function.Supplier<Object>) ((java.util.function.Function<Object, Object>) f).apply(((java.util.function.Supplier<Object>) a).get())).get();

    public static Object run = (java.util.function.Function<Object, Object>) (f) ->
        ((java.util.function.Supplier<Object>) f).get();

    public static Object $while = (java.util.function.Function<Object, Object>) (f) ->
        (java.util.function.Function<Object, Object>) (a) ->
        (java.util.function.Supplier<Object>) () -> {
            while ((Boolean) ((java.util.function.Supplier<Object>) f).get()) {
                ((java.util.function.Supplier<Object>) a).get();
            }
            return null;
        };

    public static Object $for = (java.util.function.Function<Object, Object>) (lo) ->
        (java.util.function.Function<Object, Object>) (hi) ->
        (java.util.function.Function<Object, Object>) (f) ->
        (java.util.function.Supplier<Object>) () -> {
            for (int i = (Integer) lo; i < (Integer) hi; i++) {
                ((java.util.function.Supplier<Object>) ((java.util.function.Function<Object, Object>) f).apply(i)).get();
            }
            return null;
        };

    public static Object foreach = (java.util.function.Function<Object, Object>) (as) ->
        (java.util.function.Function<Object, Object>) (f) ->
        (java.util.function.Supplier<Object>) () -> {
            for (Object item : (Object[]) as) {
                ((java.util.function.Supplier<Object>) ((java.util.function.Function<Object, Object>) f).apply(item)).get();
            }
            return null;
        };

    // A mutable cell is a one-element array.
    public static Object $new = (java.util.function.Function<Object, Object>) (val) ->
        (java.util.function.Supplier<Object>) () -> new Object[]{ val };

    public static Object read = (java.util.function.Function<Object, Object>) (ref) ->
        (java.util.function.Supplier<Object>) () -> ((Object[]) ref)[0];

    public static Object write = (java.util.function.Function<Object, Object>) (val) ->
        (java.util.function.Function<Object, Object>) (ref) ->
        (java.util.function.Supplier<Object>) () -> { ((Object[]) ref)[0] = val; return val; };

    // The { state, value } record of modifyImpl is a Map for untyped records and a
    // generated record class whose accessors are read0/read1 in label order.
    private static Object __recordField(Object record, int index, String label) {
        if (record instanceof java.util.Map) return ((java.util.Map<?, ?>) record).get(label);
        try {
            return record.getClass().getMethod("read" + index, Object.class).invoke(null, record);
        } catch (ReflectiveOperationException error) {
            throw new RuntimeException(error);
        }
    }

    public static Object modifyImpl = (java.util.function.Function<Object, Object>) (f) ->
        (java.util.function.Function<Object, Object>) (ref) ->
        (java.util.function.Supplier<Object>) () -> {
            Object[] cell = (Object[]) ref;
            Object updated = ((java.util.function.Function<Object, Object>) f).apply(cell[0]);
            cell[0] = __recordField(updated, 0, "state");
            return __recordField(updated, 1, "value");
        };
