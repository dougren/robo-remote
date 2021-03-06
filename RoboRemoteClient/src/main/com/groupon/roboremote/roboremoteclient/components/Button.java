/*
 * Copyright (c) 2012, Groupon, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 *
 * Neither the name of GROUPON nor the names of its contributors may be
 * used to endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED
 * TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.</div>
 */

package com.groupon.roboremote.roboremoteclient.components;

import com.groupon.roboremote.roboremoteclient.Solo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Button {
    private static final Logger logger = LoggerFactory.getLogger("test");

    public static boolean exists(String label) throws Exception {
        try {
            String button = Solo.getButton(label);
            if (! Solo.isVisible(button)) {
                logger.warn("Found button {}, but it is not visible");
                return false;
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public static boolean touch(String label) throws Exception {
        logger.info("Attempting to touch button: {}", label);

        if (!exists(label)) {
            logger.info("Button does not exist: {}", label);
            return false;
        }

        try {
            Solo.clickOnButton(label);
            logger.info("Touched button: {}", label);
        } catch (Exception e) {
            logger.warn("Could not touch button: {}: {}", label, e.getMessage());
        }

        return true;
    }
}
