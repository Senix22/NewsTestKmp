//
//  DeviceInfoView.swift
//  iosApp
//
//  Created by Oleh Senyk on 1/18/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared
import SwiftUI

struct DeviceInfoView: View {
    private struct RowItem: Hashable {
      let title: String
      let subtitle: String
    }

    private let items: [RowItem] = {
      let platform = DeviceInfo()

      var result: [RowItem] = [
        .init(
          title: "Operating System",
          subtitle: "\(platform.osName) \(platform.osVersion)"
        ),
        .init(
          title: "Device",
          subtitle: platform.osDeviceModel
        ),
      ]
      return result
    }()

    var body: some View {
      List {
        ForEach(items, id: \.self) { item in
          VStack(alignment: .leading) {
            Text(item.title)
              .font(.footnote)
              .foregroundStyle(.secondary)
            Text(item.subtitle)
              .font(.body)
              .foregroundStyle(.primary)
          }
          .padding(.vertical, 4)
        }
      }
    }
  }
