/*
 * Copyright [2019] [Alberto Paro]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.opensearch.plugin.analysis;

import org.apache.lucene.analysis.Analyzer;
import org.opensearch.index.analysis.AnalyzerProvider;
import org.opensearch.index.analysis.NlpAnalyzer;
import org.opensearch.indices.analysis.AnalysisModule;
import org.opensearch.plugins.Plugin;

import java.util.HashMap;
import java.util.Map;

public class AnalysisPlugin extends Plugin implements org.opensearch.plugins.AnalysisPlugin {
    @Override
    public Map<String, AnalysisModule.AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> getAnalyzers() {
        Map<String, AnalysisModule.AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> analyzers = new HashMap<>();
        analyzers.put(NlpAnalyzer.NAME, NlpAnalyzer::getCustomEnglishAnalyzerProvider);
        return analyzers;
    }
}
