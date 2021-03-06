/*
 * JAVE - A Java Audio/Video Encoder (based on FFMPEG)
 * 
 * Copyright (C) 2008-2009 Carlo Pelliccia (www.sauronsoftware.it)
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ws.schild.jave;

import java.io.Serializable;

/**
 * Attributes controlling the encoding process.
 *
 * @author Carlo Pelliccia
 */
public class EncodingAttributes implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * The format name for the encoded target multimedia file. Be sure this
     * format is supported (see {@link Encoder#getSupportedEncodingFormats()}.
     */
    private String format = null;

    /**
     * The start offset time (seconds). If null or not specified no start offset
     * will be applied.
     */
    private Float offset = null;

    /**
     * The duration (seconds) of the re-encoded stream. If null or not specified
     * the source stream, starting from the offset, will be completely
     * re-encoded in the target stream.
     */
    private Float duration = null;

    /**
     * The attributes for the encoding of the audio stream in the target
     * multimedia file. If null of not specified no audio stream will be
     * encoded. It cannot be null if also the video field is null.
     */
    private AudioAttributes audioAttributes = null;

    /**
     * The attributes for the encoding of the video stream in the target
     * multimedia file. If null of not specified no video stream will be
     * encoded. It cannot be null if also the audio field is null.
     */
    private VideoAttributes videoAttributes = null;

    /**
     * Should we try to copy over the meta data?
     */
    private boolean mapMetaData= false;
    
    /**
     * Maximum number of cores/cpus to use for conversion
     * -1 means use default of ffmpeg
     */
    private int filterThreads= -1;
    /**
     * Number of threads to use for decoding (if supported by codec)
     */
    private int decodingThreads= -1;
    /**
     * Number of threads to use for encoding (if supported by codec)
     */
    private int encodingThreads= -1;

    
    /**
     * Returns the format name for the encoded target multimedia file.
     *
     * @return The format name for the encoded target multimedia file.
     */
    public String getFormat() {
        return format;
    }

    /**
     * Sets the format name for the encoded target multimedia file. Be sure this
     * format is supported (see {@link Encoder#getSupportedEncodingFormats()}.
     *
     * @param format The format name for the encoded target multimedia file.
     * @return this instance
     */
    public EncodingAttributes setFormat(String format) {
        this.format = format;
        return this;
    }

    /**
     * Returns the start offset time (seconds).
     *
     * @return The start offset time (seconds).
     */
    public Float getOffset() {
        return offset;
    }

    /**
     * Sets the start offset time (seconds). If null or not specified no start
     * offset will be applied.
     *
     * @param offset The start offset time (seconds).
     * @return this instance
     */
    public EncodingAttributes setOffset(Float offset) {
        this.offset = offset;
        return this;
    }

    /**
     * Returns the duration (seconds) of the re-encoded stream.
     *
     * @return The duration (seconds) of the re-encoded stream.
     */
    public Float getDuration() {
        return duration;
    }

    /**
     * Sets the duration (seconds) of the re-encoded stream. If null or not
     * specified the source stream, starting from the offset, will be completely
     * re-encoded in the target stream.
     *
     * @param duration The duration (seconds) of the re-encoded stream.
     * @return this instance
     */
    public EncodingAttributes setDuration(Float duration) {
        this.duration = duration;
        return this;
    }

    /**
     * Returns the attributes for the encoding of the audio stream in the target
     * multimedia file.
     *
     * @return The attributes for the encoding of the audio stream in the target
     * multimedia file.
     */
    public AudioAttributes getAudioAttributes() {
        return audioAttributes;
    }

    /**
     * Sets the attributes for the encoding of the audio stream in the target
     * multimedia file. If null of not specified no audio stream will be
     * encoded. It cannot be null if also the video field is null.
     *
     * @param audioAttributes The attributes for the encoding of the audio
     * stream in the target multimedia file.
     * @return this instance
     */
    public EncodingAttributes setAudioAttributes(AudioAttributes audioAttributes) {
        this.audioAttributes = audioAttributes;
        return this;
    }

    /**
     * Returns the attributes for the encoding of the video stream in the target
     * multimedia file.
     *
     * @return The attributes for the encoding of the video stream in the target
     * multimedia file.
     */
    public VideoAttributes getVideoAttributes() {
        return videoAttributes;
    }

    /**
     * Sets the attributes for the encoding of the video stream in the target
     * multimedia file. If null of not specified no video stream will be
     * encoded. It cannot be null if also the audio field is null.
     *
     * @param videoAttributes The attributes for the encoding of the video
     * stream in the target multimedia file.
     * @return this instance
     */
    public EncodingAttributes setVideoAttributes(VideoAttributes videoAttributes) {
        this.videoAttributes = videoAttributes;
        return this;
    }

    @Override
    public String toString() {
        return getClass().getName() + "(format=" + format + ", offset="
                + offset + ", duration=" + duration + ", audioAttributes="
                + audioAttributes + ", videoAttributes=" + videoAttributes
                + ")";
    }

    /**
     * @return the mapMetaData
     */
    public boolean isMapMetaData() {
        return mapMetaData;
    }

    /**
     * Copy over meta data from original file to new output if possible
     * 
     * @param mapMetaData the mapMetaData to set
     * @return this instance
     */
    public EncodingAttributes setMapMetaData(boolean mapMetaData) {
        this.mapMetaData = mapMetaData;
        return this;
    }

    /**
     * @return Maximum number of cores/cpus to use for filtering
     * -1 means use default of ffmpeg
     * 
     */
    public int getFilterThreads() {
        return filterThreads;
    }

    /**
     * ffmpeg uses multiple cores for filtering
     * 
     * @param filterThreads Maximum number of cores/cpus to use
     * -1 means use default of ffmpeg
     * @return this instance
     */
    public EncodingAttributes setFilterThreads(int filterThreads) {
        this.filterThreads = filterThreads;
        return this;
    }

    /**
     * Number of threads to use for decoding (if supported by codec)
     * -1 means use default of ffmpeg
     * @return the decodingThreads
     */
    public int getDecodingThreads() {
        return decodingThreads;
    }

    /**
     * Number of threads to use for decoding (if supported by codec)
     * -1 means use default of ffmpeg
     * @param decodingThreads the decodingThreads to set
     * @return this instance
     */
    public EncodingAttributes setDecodingThreads(int decodingThreads) {
        this.decodingThreads = decodingThreads;
        return this;
    }

    /**
     * Number of threads to use for encoding (if supported by codec)
     * -1 means use default of ffmpeg
     * @return the encodingThreads
     */
    public int getEncodingThreads() {
        return encodingThreads;
    }

    /**
     * Number of threads to use for encoding (if supported by codec)
     * -1 means use default of ffmpeg
     * @param encodingThreads the encodingThreads to set
     * @return this instance
     */
    public EncodingAttributes setEncodingThreads(int encodingThreads) {
        this.encodingThreads = encodingThreads;
        return this;
    }
    
}
