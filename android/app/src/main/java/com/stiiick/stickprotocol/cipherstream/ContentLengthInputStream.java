/*
 *  Copyright © 2018-2022 Sticknet.
 *
 *  This source code is licensed under the GPLv3 license found in the
 *  LICENSE file in the root directory of this source tree.
 */

package com.stiiick.stickprotocol.cipherstream;

import com.stiiick.stickprotocol.util.Util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ContentLengthInputStream extends FilterInputStream {

    private long bytesRemaining;

    public ContentLengthInputStream(InputStream inputStream, long contentLength) {
        super(inputStream);
        this.bytesRemaining = contentLength;
    }

    @Override
    public int read() throws IOException {
        if (bytesRemaining == 0) return -1;
        int result = super.read();
        bytesRemaining--;

        return result;
    }

    @Override
    public int read(byte[] buffer) throws IOException {
        return read(buffer, 0, buffer.length);
    }

    @Override
    public int read(byte[] buffer, int offset, int length) throws IOException {
        if (bytesRemaining == 0) return -1;

        int result = super.read(buffer, offset, Math.min(length, Util.toIntExact(bytesRemaining)));

        bytesRemaining -= result;
        return result;
    }

}
