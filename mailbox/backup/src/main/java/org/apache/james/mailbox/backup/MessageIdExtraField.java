/****************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one   *
 * or more contributor license agreements.  See the NOTICE file *
 * distributed with this work for additional information        *
 * regarding copyright ownership.  The ASF licenses this file   *
 * to you under the Apache License, Version 2.0 (the            *
 * "License"); you may not use this file except in compliance   *
 * with the License.  You may obtain a copy of the License at   *
 *                                                              *
 *   http://www.apache.org/licenses/LICENSE-2.0                 *
 *                                                              *
 * Unless required by applicable law or agreed to in writing,   *
 * software distributed under the License is distributed on an  *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY       *
 * KIND, either express or implied.  See the License for the    *
 * specific language governing permissions and limitations      *
 * under the License.                                           *
 ****************************************************************/

package org.apache.james.mailbox.backup;

import java.util.Optional;

import org.apache.commons.compress.archivers.zip.ZipShort;
import org.apache.james.mailbox.model.MessageId;

public class MessageIdExtraField extends StringExtraField {

    public static final ZipShort ID_AL = new ZipShort(0x6C61); // "al" in little-endian

    public MessageIdExtraField() {
        super();
    }

    public MessageIdExtraField(String value) {
        super(Optional.of(value));
    }

    public MessageIdExtraField(Optional<String> value) {
        super(value);
    }

    public MessageIdExtraField(MessageId messageId) {
        super(Optional.of(messageId.serialize()));
    }

    @Override
    public ZipShort getHeaderId() {
        return ID_AL;
    }
}
