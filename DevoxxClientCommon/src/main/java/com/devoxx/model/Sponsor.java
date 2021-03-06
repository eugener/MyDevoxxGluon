/**
 * Copyright (c) 2016, Gluon Software
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the
 * following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation and/or other materials provided
 *    with the distribution.
 *
 * 3. Neither the name of the copyright holder nor the names of its contributors may be used to endorse
 *    or promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.devoxx.model;

import com.devoxx.util.SponsorCategory;

import java.util.Locale;
import java.util.Objects;

public class Sponsor extends Searchable implements Mergeable<Sponsor> {
    private String uuid;
    private SponsorCategory section;
    private String name;
    private String summary;
    private String description;
    private String picture;
    private boolean splash;
    private boolean banner;

    public Sponsor() { }

    public Sponsor(String uuid, SponsorCategory section, String name, String summary, String description, String picture,
                   boolean splash, boolean banner) {
        this.uuid = uuid;
        this.section = section;
        this.name = name;
        this.summary = summary;
        this.description = description;
        this.picture = picture;
        this.splash = splash;
        this.banner = banner;
    }

    public String getUuid() {
        return uuid;
    }

    public SponsorCategory getSection() {
        return section;
    }

    public String getName() {
        return name;
    }

    public String getSummary() {
        return summary;
    }

    public String getDescription() {
        return description;
    }

    public String getPicture() {
        return picture;
    }

    public boolean isSplash() {
        return splash;
    }

    public boolean isBanner() {
        return banner;
    }

    @Override
    public boolean contains(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return false;
        } 
        String lowerKeyword = keyword.toLowerCase(Locale.ROOT);
        return containsKeyword(getName(), lowerKeyword)        ||
               containsKeyword(getDescription(), lowerKeyword) ||
               containsKeyword(getSection(), lowerKeyword)     ||
               containsKeyword(getSummary(), lowerKeyword);

    }

    @Override
    public boolean merge(Sponsor other) {
        boolean changed = false;
        if (!Objects.equals(other.section, this.section)) {
            changed = true;
            this.section = other.section;
        }
        if (!Objects.equals(other.name, this.name)) {
            changed = true;
            this.name = other.name;
        }
        if (!Objects.equals(other.summary, this.summary)) {
            changed = true;
            this.summary = other.summary;
        }
        if (!Objects.equals(other.description, this.description)) {
            changed = true;
            this.description = other.description;
        }
        if (!Objects.equals(other.picture, this.picture)) {
            changed = true;
            this.picture = other.picture;
        }
        if (other.splash != this.splash) {
            changed = true;
            this.splash = other.splash;
        }
        if (other.banner != this.banner) {
            changed = true;
            this.banner = other.banner;
        }
        return changed;
    }
}
