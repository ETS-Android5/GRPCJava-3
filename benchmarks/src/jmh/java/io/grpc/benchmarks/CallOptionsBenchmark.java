/*
 * Copyright 2016, Google Inc. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *    * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *
 *    * Neither the name of Google Inc. nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package io.grpc.benchmarks;

import io.grpc.CallOptions;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Call options benchmark.
 */
@State(Scope.Benchmark)
public class CallOptionsBenchmark {

  @Param({"1", "2", "4", "8"})
  public int customOptionsCount;

  private List<CallOptions.Key<String>> customOptions;

  private CallOptions allOpts;
  private List<CallOptions.Key<String>> shuffledCustomOptions;

  /**
   * Setup.
   */
  @Setup
  public void setUp() throws Exception {
    customOptions = new ArrayList<CallOptions.Key<String>>(customOptionsCount);
    for (int i = 0; i < customOptionsCount; i++) {
      customOptions.add(CallOptions.Key.of("name " + i, "defaultvalue"));
    }

    allOpts = CallOptions.DEFAULT;
    for (int i = 0; i < customOptionsCount; i++) {
      allOpts = allOpts.withOption(customOptions.get(i), "value");
    }

    shuffledCustomOptions = new ArrayList<CallOptions.Key<String>>(customOptions);
    // Make the shuffling deterministic
    Collections.shuffle(shuffledCustomOptions, new Random(1));
  }

  /**
   * Adding custom call options without duplicate keys.
   */
  @Benchmark
  @BenchmarkMode(Mode.SampleTime)
  @OutputTimeUnit(TimeUnit.NANOSECONDS)
  public CallOptions withOption() {
    CallOptions opts = CallOptions.DEFAULT;
    for (int i = 0; i < customOptions.size(); i++) {
      opts = opts.withOption(customOptions.get(i), "value");
    }
    return opts;
  }

  /**
   * Adding custom call options, overwritting existing keys.
   */
  @Benchmark
  @BenchmarkMode(Mode.SampleTime)
  @OutputTimeUnit(TimeUnit.NANOSECONDS)
  public CallOptions withOptionDuplicates() {
    CallOptions opts = allOpts;
    for (int i = 1; i < shuffledCustomOptions.size(); i++) {
      opts = opts.withOption(shuffledCustomOptions.get(i), "value2");
    }
    return opts;
  }
}
