/**
 * Copyright 2016-2017 The Reaktivity Project
 *
 * The Reaktivity Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package org.reaktivity.nukleus.maven.plugin.internal.generated;

import static java.nio.ByteBuffer.allocateDirect;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.PrimitiveIterator;

import org.agrona.MutableDirectBuffer;
import org.agrona.concurrent.UnsafeBuffer;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.reaktivity.reaktor.internal.test.types.inner.IntegerFixedArraysFW;

public class IntegerFixedArraysFWTest
{
    private final MutableDirectBuffer buffer = new UnsafeBuffer(allocateDirect(150))
    {
        {
            // Make sure the code is not secretly relying upon memory being initialized to 0
            setMemory(0, capacity(), (byte) 0xFF);
        }
    };
    private final MutableDirectBuffer expected = new UnsafeBuffer(allocateDirect(150))
    {
        {
            setMemory(0, capacity(), (byte) 0xFF);
        }
    };
    private final IntegerFixedArraysFW.Builder flyweightRW = new IntegerFixedArraysFW.Builder();
    private final IntegerFixedArraysFW flyweightRO = new IntegerFixedArraysFW();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldFailToBuildWithInsufficientSpace()
    {

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldFailToSetUint8ArrayBeyondLimit()
    {
//      flyweightRW.wrap(buffer, 0, buffer.capacity())
//      .appendUint8Array(1, 10)
    }

    @Test
    public void shouldReadAllValues() throws Exception
    {
        buffer.putByte(0, (byte) 0xFF); // uint8Array[1]
        buffer.putShort(1, (short) 3); // uint16Array[2]
        buffer.putShort(3, (short) 0xFFFF);
        buffer.putInt(5, 10); // uint32Array[3]
        buffer.putInt(9, 0xFFFFFFFF);
        buffer.putInt(13, 12);
        buffer.putLong(17, 20L); // uint64Array[4]
        buffer.putLong(25, 21L);
        buffer.putLong(33, 22L);
        buffer.putLong(41, 23L);

        buffer.putByte(49, (byte) -1); // anchor

        buffer.putByte(50, (byte) 127); // int8Array[1]
        buffer.putShort(51, (short) 3); // int16Array[2]
        buffer.putShort(53, (short) 0xFFFF);
        buffer.putInt(55, 10); // int32Array[3]
        buffer.putInt(59, 0xFFFFFFFF);
        buffer.putInt(63, 12);
        buffer.putLong(67, -20L); // int64Array[4]
        buffer.putLong(75, -21L);
        buffer.putLong(83, -22L);
        buffer.putLong(91, -23L);

        flyweightRO.wrap(buffer,  0,  buffer.capacity());

        PrimitiveIterator.OfInt uint8Array = flyweightRO.uint8Array();
        assertEquals(0xFF, uint8Array.nextInt());

        PrimitiveIterator.OfInt uint16Array = flyweightRO.uint16Array();
        assertEquals(3, uint16Array.nextInt());
        assertEquals(0xFFFF, uint16Array.nextInt());

        PrimitiveIterator.OfLong uint32Array = flyweightRO.uint32Array();
        assertEquals(10, uint32Array.nextLong());
        assertEquals(0xFFFFFFFFL, uint32Array.nextLong());
        assertEquals(12, uint32Array.nextLong());

        PrimitiveIterator.OfLong uint64Array = flyweightRO.uint64Array();
        assertEquals(20, uint64Array.nextLong());
        assertEquals(21, uint64Array.nextLong());
        assertEquals(22, uint64Array.nextLong());
        assertEquals(23, uint64Array.nextLong());

        assertNull(flyweightRO.anchor().asString());

        PrimitiveIterator.OfInt int8Array = flyweightRO.int8Array();
        assertEquals(127, int8Array.nextInt());

        PrimitiveIterator.OfInt int16Array = flyweightRO.int16Array();
        assertEquals(3, int16Array.nextInt());
        assertEquals(-1, int16Array.nextInt());

        PrimitiveIterator.OfInt int32Array = flyweightRO.int32Array();
        assertEquals(10, int32Array.nextInt());
        assertEquals(-1, int32Array.nextInt());
        assertEquals(12, int32Array.nextInt());

        PrimitiveIterator.OfLong int64Array = flyweightRO.int64Array();
        assertEquals(-20, int64Array.nextLong());
        assertEquals(-21, int64Array.nextLong());
        assertEquals(-22, int64Array.nextLong());
        assertEquals(-23, int64Array.nextLong());
    }

    @Test
    public void shouldSetAllValuesUsingAppend() throws Exception
    {
        flyweightRW.wrap(buffer, 0, buffer.capacity())
                .appendUint8Array(0xFF)
                .appendUint16Array(3)
                .appendUint16Array(0xFFFF)
                .appendUint32Array(10)
                .appendUint32Array(11)
                .appendUint32Array(0xFFFFFFFFL)
                .appendUint64Array(20)
                .appendUint64Array(21)
                .appendUint64Array(22)
                .appendUint64Array(23)
                .anchor("anchor")
                .appendInt8Array((byte) 127)
                .appendInt16Array((short) 3)
                .appendInt16Array((short) 0xFFFF)
                .appendInt32Array(-10)
                .appendInt32Array(-11)
                .appendInt32Array(-12)
                .appendInt64Array(-20)
                .appendInt64Array(-21)
                .appendInt64Array(-22)
                .appendInt64Array(-23)
                .build();
        flyweightRO.wrap(buffer,  0,  buffer.capacity());

        expected.putByte(0, (byte) 0xFF); // uint8Array[1]
        expected.putShort(1, (short) 3); // uint16Array[2]
        expected.putShort(3, (short) 0xFFFF);
        expected.putInt(5, 10); // uint32Array[3]
        expected.putInt(9, 11);
        expected.putInt(13, 0xFFFFFFFF);
        expected.putLong(17, 20L); // uint64Array[4]
        expected.putLong(25, 21L);
        expected.putLong(33, 22L);
        expected.putLong(41, 23L);
        expected.putByte(49, (byte) 6);
        expected.putStringWithoutLengthUtf8(50, "anchor");
        expected.putByte(56, (byte) 127);
        expected.putShort(57, (short) 3); // int16Array[2]
        expected.putShort(59, (short) 0xFFFF);
        expected.putInt(61, -10); // int32Array[3]
        expected.putInt(65, -11);
        expected.putInt(69, -12);
        expected.putLong(73, -20L); // int64Array[4]
        expected.putLong(81, -21L);
        expected.putLong(89, -22L);
        expected.putLong(97, -23L);

        byte[] bytes = new byte[buffer.capacity()];
        buffer.getBytes(0, bytes);
        System.out.println(javax.xml.bind.DatatypeConverter.printHexBinary(bytes));

        expected.getBytes(0, bytes);
        System.out.println(javax.xml.bind.DatatypeConverter.printHexBinary(bytes));

        assertEquals(expected.byteBuffer(), buffer.byteBuffer());
    }

    @Test
    public void shouldConvertToString() throws Exception
    {
//        flyweightRW.wrap(buffer, 0, buffer.capacity())
//        .unsigned8(0, 10)
//        .unsigned16(1, 20)
//        .unsigned32(2, 30)
//        .unsigned64(3, 40)
//        .signed8(0, (byte) -10)
//        .signed16(1, (short) -20)
//        .signed32(2, -30)
//        .signed64(2, -40)
//        .signed64(3, -80)
//        .build();
//        flyweightRO.wrap(buffer,  0,  100);
//        assertTrue(flyweightRO.toString().contains("unsigned32=[0, 0, 30]"));
//        assertTrue(flyweightRO.toString().contains("signed64=[0, 0, -40, -80]"));
    }

}
