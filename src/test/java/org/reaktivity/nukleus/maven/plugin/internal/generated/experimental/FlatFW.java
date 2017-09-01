 // TODO: license
package org.reaktivity.nukleus.maven.plugin.internal.generated.experimental;

import static java.lang.String.format;

import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.BitSet;

import javax.annotation.Generated;
import org.agrona.BitUtil;
import org.agrona.DirectBuffer;
import org.agrona.MutableDirectBuffer;

@Generated("reaktivity")
public final class FlatFW extends Flyweight {
  public static final int FIELD_OFFSET_FIXED1 = 0;

  private static final int FIELD_SIZE_FIXED1 = BitUtil.SIZE_OF_BYTE;

  public static final int FIELD_OFFSET_FIXED2 = FIELD_OFFSET_FIXED1 + FIELD_SIZE_FIXED1;

  private static final int FIELD_SIZE_FIXED2 = BitUtil.SIZE_OF_SHORT;

  public static final int FIELD_OFFSET_STRING1 = FIELD_OFFSET_FIXED2 + FIELD_SIZE_FIXED2;

  public static final int FIELD_OFFSET_FIXED3 = 0;

  private static final int FIELD_SIZE_FIXED3 = BitUtil.SIZE_OF_INT;

  public static final int FIELD_OFFSET_STRING2 = FIELD_OFFSET_FIXED3 + FIELD_SIZE_FIXED3;

  private final StringFW string1RO = new StringFW();

  private final StringFW string2RO = new StringFW();

  public int fixed1() {
    return buffer().getByte(offset() + FIELD_OFFSET_FIXED1) & 0xFF;
  }

  public int fixed2() {
    return buffer().getShort(offset() + FIELD_OFFSET_FIXED2, ByteOrder.BIG_ENDIAN) & 0xFFFF;
  }

  public StringFW string1() {
    return string1RO;
  }

  public int fixed3() {
    return buffer().getInt(string1().limit() + FIELD_OFFSET_FIXED3);
  }

  public StringFW string2() {
    return string2RO;
  }

  @Override
  public FlatFW wrap(DirectBuffer buffer, int offset, int maxLimit) {
    super.wrap(buffer, offset, maxLimit);
    string1RO.wrap(buffer, offset + FIELD_OFFSET_STRING1, maxLimit);
    string2RO.wrap(buffer, string1RO.limit() + FIELD_OFFSET_STRING2, maxLimit);
    checkLimit(limit(), maxLimit);
    return this;
  }

  @Override
  public int limit() {
    return string2().limit();
  }

  @Override
  public String toString() {
    return String.format("FLAT [fixed1=%d, fixed2=%d, string1=%s, fixed3=%d, string2=%s]", fixed1(), fixed2(), string1RO.asString(), fixed3(), string2RO.asString());
  }

  public static final class Builder extends Flyweight.Builder<FlatFW> {
    private static final int FIELD_COUNT = 5;
    private static final int DEFAULT_FIXED2 = 222;
    private static final int DEFAULT_FIXED3 = 333;

    private static final int INDEX_FIXED1 = 0;
    private static final int INDEX_FIXED2 = 1;
    private static final int INDEX_STRING1 = 2;
    private static final int INDEX_FIXED3 = 3;
    private static final int INDEX_STRING2 = 4;

    private static final BitSet FIELDS_WITH_DEFAULTS = new BitSet(FIELD_COUNT);

    static {
        FIELDS_WITH_DEFAULTS.set(INDEX_FIXED2);
        FIELDS_WITH_DEFAULTS.set(INDEX_FIXED3);
    }

    private static final String[] FIELD_NAMES = new String[]
    {
        "fixed1",
        "fixed2",
        "string1",
        "fixed3",
        "string2"
    };

    private final BitSet fieldsSet = new BitSet(FIELD_COUNT);
    private final StringFW.Builder string1RW = new StringFW.Builder();
    private final StringFW.Builder string2RW = new StringFW.Builder();

    public Builder() {
      super(new FlatFW());
    }

    public Builder fixed1(int value) {
      checkFieldNotSet(INDEX_FIXED1);
      checkFieldsSet(0, INDEX_FIXED1);
      int newLimit = limit() + FIELD_SIZE_FIXED1;
      checkLimit(newLimit, maxLimit());
      buffer().putByte(limit(), (byte)(value & 0xFF));
      fieldsSet.set(INDEX_FIXED1);
      limit(newLimit);
      return this;
    }

    public Builder fixed2(int value) {
      checkFieldNotSet(INDEX_FIXED2);
      checkFieldsSet(0, INDEX_FIXED2);
      int newLimit = limit() + FIELD_SIZE_FIXED2;
      checkLimit(newLimit, maxLimit());
      buffer().putShort(limit(), (short)(value & 0xFFFF), ByteOrder.BIG_ENDIAN);
      fieldsSet.set(INDEX_FIXED2);
      limit(newLimit);
      return this;
    }

    private StringFW.Builder string1() {
      checkFieldNotSet(INDEX_STRING1);
      if (!fieldsSet.get(INDEX_FIXED2))
      {
        fixed2(DEFAULT_FIXED2);
      }
      checkFieldsSet(0, INDEX_STRING1);
      return string1RW.wrap(buffer(), limit(),  maxLimit());
    }

    public Builder string1(String value) {
      StringFW.Builder string1 = string1();
      string1.set(value, StandardCharsets.UTF_8);
      fieldsSet.set(INDEX_STRING1);
      limit(string1.build().limit());
      return this;
    }

    public Builder string1(StringFW value) {
      StringFW.Builder string1 = string1();
      string1.set(value);
      fieldsSet.set(INDEX_STRING1);
      limit(string1.build().limit());
      return this;
    }

    public Builder string1(DirectBuffer buffer, int offset, int length) {
      StringFW.Builder string1 = string1();
      string1.set(buffer, offset, length);
      fieldsSet.set(INDEX_STRING1);
      limit(string1.build().limit());
      return this;
    }

    public Builder fixed3(int value) {
        checkFieldNotSet(INDEX_FIXED3);
        checkFieldsSet(0, INDEX_FIXED3);
        int newLimit = limit() + FIELD_SIZE_FIXED3;
        checkLimit(newLimit, maxLimit());
        buffer().putInt(limit(), value);
        fieldsSet.set(INDEX_FIXED3);
        limit(newLimit);
      return this;
    }

    private StringFW.Builder string2() {
      checkFieldNotSet(INDEX_STRING2);
      if (!fieldsSet.get(INDEX_FIXED3))
      {
        fixed3(DEFAULT_FIXED3);
      }
      checkFieldsSet(0, INDEX_STRING2);
      return string2RW.wrap(buffer(), limit(),  maxLimit());
    }

    public Builder string2(String value) {
      StringFW.Builder string2 = string2();
      string2.set(value, StandardCharsets.UTF_8);
      fieldsSet.set(INDEX_STRING2);
      limit(string2.build().limit());
      return this;
    }

    public Builder string2(StringFW value) {
      StringFW.Builder string2 = string2();
      string2.set(value);
      fieldsSet.set(INDEX_STRING2);
      limit(string2.build().limit());
      return this;
    }

    public Builder string2(DirectBuffer buffer, int offset, int length) {
      StringFW.Builder string2 = string2();
      string2.set(buffer, offset, length);
      fieldsSet.set(INDEX_STRING2);
      limit(string2.build().limit());
      return this;
    }

    @Override
    public Builder wrap(MutableDirectBuffer buffer, int offset, int maxLimit) {
      fieldsSet.clear();
      super.wrap(buffer, offset, maxLimit);
      limit(offset);
      return this;
    }

    @Override
    public FlatFW build()
    {
      checkFieldsSet(0, FIELD_COUNT);
      fieldsSet.clear();
      return super.build();
    }

    private void checkFieldNotSet(int index) {
      if (fieldsSet.get(index))
      {
        throw new IllegalStateException(format("Field \"%s\" has already been set", FIELD_NAMES[index]));
      }
    }

    private void checkFieldsSet(
        int fromIndex,
        int toIndex)
    {
      int fieldNotSet = fromIndex - 1;
      do
      {
        fieldNotSet = fieldsSet.nextClearBit(fieldNotSet + 1);
      } while (fieldNotSet < toIndex && FIELDS_WITH_DEFAULTS.get(fieldNotSet));

      if (fieldNotSet < toIndex)
      {
        throw new IllegalStateException(format("Required field \"%s\" is not set", FIELD_NAMES[fieldNotSet]));
      }
    }

  }
}
