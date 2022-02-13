/*
 *  Copyright © 2018-2022 StickNet.
 *
 *  This source code is licensed under the GPLv3 license found in the
 *  LICENSE file in the root directory of this source tree.
 */

package com.stiiick.stickprotocol.util;

import java.util.UUID;
import java.util.regex.Pattern;

public final class UuidUtil {

    private static final Pattern UUID_PATTERN = Pattern.compile("[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}", Pattern.CASE_INSENSITIVE);

    private UuidUtil() { }

    public static UUID parseOrNull(String uuid) {
        return isUuid(uuid) ? parseOrThrow(uuid) : null;
    }

    public static UUID parseOrThrow(String uuid) {
        return UUID.fromString(uuid);
    }

    public static boolean isUuid(String uuid) {
        return uuid != null && UUID_PATTERN.matcher(uuid).matches();
    }


}
